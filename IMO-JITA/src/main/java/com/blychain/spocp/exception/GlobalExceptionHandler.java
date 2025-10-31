package com.blychain.spocp.exception;


import com.blychain.spocp.transferObject.ErrorResponseTO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseTO> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String rootCauseMessage = getRootCauseMessage(ex);

        String errorMessage = "Database integrity error occurred";

        if (rootCauseMessage == null) {
            rootCauseMessage = ex.getMessage();
        }

        if (rootCauseMessage.contains("violates foreign key constraint")) {
            errorMessage = extractForeignKeyMessage(rootCauseMessage);

        } else if (rootCauseMessage.contains("duplicate key value")) {
            errorMessage = extractUniqueViolationMessage(rootCauseMessage);

        } else if (rootCauseMessage.contains("violates not-null constraint")) {
            errorMessage = extractNotNullViolationMessage(rootCauseMessage);

        } else if (rootCauseMessage.contains("violates check constraint")) {
            errorMessage = extractCheckConstraintMessage(rootCauseMessage);
        }

        ErrorResponseTO errorResponse = ErrorResponseTO.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(errorMessage)
                .build();

        return ResponseEntity.badRequest().body(errorResponse);
    }

    private String getRootCauseMessage(Throwable ex) {
        Throwable root = ex;
        while (root.getCause() != null && root.getCause() != root) {
            root = root.getCause();
        }
        return root.getMessage();
    }

    private String extractForeignKeyMessage(String rootMessage) {
        // Example: Key (un_location_code)=(GPPAP) is not present in table "locations"
        if (rootMessage.contains("Key")) {
            String keyInfo = rootMessage.substring(rootMessage.indexOf("Key"));

            String column = keyInfo.substring(keyInfo.indexOf("(") + 1, keyInfo.indexOf(")")).trim();
            String valuePart = keyInfo.substring(keyInfo.indexOf(")=") + 2).trim();

            if (valuePart.contains("is not present")) {
                valuePart = valuePart.substring(0, valuePart.indexOf("is not present")).trim();
            }

            String fieldName = toCamelCase(column);
            return fieldName + " = " + valuePart + " is not valid";
        }
        return "Invalid foreign key reference";
    }

    private String extractUniqueViolationMessage(String rootMessage) {
        // Example: duplicate key value violates unique constraint "users_email_key"
        // Detail: Key (email)=(abc@test.com) already exists.
        if (rootMessage.contains("Key")) {
            String keyInfo = rootMessage.substring(rootMessage.indexOf("Key"));

            String column = keyInfo.substring(keyInfo.indexOf("(") + 1, keyInfo.indexOf(")")).trim();
            String valuePart = keyInfo.substring(keyInfo.indexOf(")=") + 2).trim();

            if (valuePart.contains("already exists")) {
                valuePart = valuePart.substring(0, valuePart.indexOf("already exists")).trim();
            }

            String fieldName = toCamelCase(column);
            return fieldName + " = " + valuePart + " already exists";
        }
        return "Duplicate value violates unique constraint";
    }

    private String extractNotNullViolationMessage(String rootMessage) {
        // Example: null value in column "name" violates not-null constraint
        if (rootMessage.contains("column")) {
            String col = rootMessage.substring(rootMessage.indexOf("column") + 7).trim(); // skip "column"
            if (col.contains("violates")) {
                col = col.substring(0, col.indexOf("violates")).trim();
            }
            col = col.replaceAll("\"", ""); // remove quotes if present
            String fieldName = toCamelCase(col);
            return fieldName + " cannot be null";
        }
        return "A required field cannot be null";
    }

    private String extractCheckConstraintMessage(String rootMessage) {
        // Example: violates check constraint "orders_positive_amount"
        if (rootMessage.contains("check constraint")) {
            // If you want field-specific parsing, regex can extract it
            return "Value violates business rule";
        }
        return "Value violates business rule";
    }

    private String toCamelCase(String snakeCase) {
        StringBuilder result = new StringBuilder();
        boolean nextUpper = false;
        for (char c : snakeCase.toCharArray()) {
            if (c == '_') {
                nextUpper = true;
            } else {
                result.append(nextUpper ? Character.toUpperCase(c) : c);
                nextUpper = false;
            }
        }
        return result.toString();
    }


    // Field validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseTO> handleValidationErrors(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(f -> "Invalid value for field '" + f.getField() + "': " + f.getDefaultMessage())
                .collect(Collectors.joining("; "));
        return buildErrorResponse(HttpStatus.BAD_REQUEST, message);
    }

    // Invalid JSON / enum values
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponseTO> handleJsonParseError(HttpMessageNotReadableException ex) {
        String message = "Invalid input. Please check your data or selected options.";

        Throwable cause = ex.getMostSpecificCause();
        if (cause instanceof com.fasterxml.jackson.databind.exc.InvalidFormatException invalidFormatEx) {
            // Get rejected value
            Object rejectedValue = invalidFormatEx.getValue();
            // Get field path
            String field = invalidFormatEx.getPath().stream()
                    .map(ref -> ref.getFieldName())
                    .filter(f -> f != null)
                    .collect(Collectors.joining("."));
            // Build allowed values for enums
            Object targetType = invalidFormatEx.getTargetType();
            if (targetType != null && ((Class<?>) targetType).isEnum()) {
                message = "Invalid value '" + rejectedValue + "' for field '" + field;
            } else {
                message = "Invalid value '" + rejectedValue + "' for field '" + field + "'.";
            }
        }

        return buildErrorResponse(HttpStatus.BAD_REQUEST, message);
    }


    // Constraint violations (path/query params)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseTO> handleConstraintViolation(ConstraintViolationException ex) {
        String message = ex.getConstraintViolations()
                .stream()
                .map(v -> "Invalid value for field '" + v.getPropertyPath() + "': " + v.getMessage())
                .collect(Collectors.joining("; "));
        return buildErrorResponse(HttpStatus.BAD_REQUEST, message);
    }


    // Unexpected errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseTO> handleGenericException(Exception ex) {
        String message = "Something went wrong. Please try again or contact support.";
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponseTO> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        String path = ex.getRequestURL();
        String message = String.format("Invalid endpoint '%s'. Please check the URL path and case sensitivity.", path);
        return buildErrorResponse(HttpStatus.NOT_FOUND, message);
    }

    private ResponseEntity<ErrorResponseTO> buildErrorResponse(HttpStatus status, String message) {
        ErrorResponseTO response = new ErrorResponseTO(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message
        );
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponseTO> handleAppException(AppException ex) {
        return buildErrorResponse(ex.getStatus(), ex.getMessage());
    }


}





