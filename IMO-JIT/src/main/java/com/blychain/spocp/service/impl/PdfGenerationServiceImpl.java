package com.blychain.spocp.service.impl;

import com.blychain.spocp.exception.AppException;
import com.blychain.spocp.service.PdfGenerationService;
import com.blychain.spocp.transferObject.PdfResponseTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class PdfGenerationServiceImpl implements PdfGenerationService {
    private static final Logger logger = LoggerFactory.getLogger(PdfGenerationServiceImpl.class);


    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Value("${fileflow.baseUrl}")
    private String baseUrl;

    @Value("${fileflow.pdfgenerationpath}")
    private String path;

    @Value("${auth.username}")
    private String username;

    @Value("${auth.password}")
    private String password;


    private void logHttpRequest(HttpRequest request) {
        logger.info("=============== HTTP REQUEST =====================");
        logger.info("Method: {}", request.method());
        logger.info("URI: {}", request.uri());
        request.headers().map().forEach((name, values) ->
                values.forEach(value -> logger.info("{}: {}", name, value))
        );
        logger.info("==================================");
    }

    private void logHttpResponse(HttpResponse<?> response) {
        logger.info("===============HTTP RESPONSE ==================");
        logger.info("Status Code: {}", response.statusCode());
        response.headers().map().forEach((name, values) ->
                values.forEach(value -> logger.info("{}: {}", name, value))
        );
        if (response.body() instanceof String) {
            logger.info("Body: {}", response.body());
        } else if (response.body() instanceof byte[]) {
            logger.info("Body (bytes): {} bytes", ((byte[]) response.body()).length);
        } else {
            logger.info("Body: {}", response.body());
        }
        logger.info("=====================");
    }

    private URI buildGeneratePdfUri(String pdfName, String templateName) {
        return UriComponentsBuilder.fromUriString(baseUrl)
                .path(path)
                .queryParam("pdfName", pdfName)
                .queryParam("templateName", templateName)
                .build()
                .toUri();
    }

    private URI buildGetPdfUri(String pdfName) {
        return UriComponentsBuilder.fromUriString(baseUrl)
                .path(path + pdfName)
                .build()
                .toUri();
    }

    @Override
    public ResponseEntity<PdfResponseTO> generatePdf(String pdfName, String templateName, Object payload) {
        if (pdfName == null || pdfName.trim().isEmpty()) {
            throw new AppException("PdfName must not be null or empty", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (templateName == null || templateName.trim().isEmpty()) {
            throw new AppException("TemplateName must not be null or empty", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (payload == null) {
            throw new AppException("Payload must not be null", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            URI uri = buildGeneratePdfUri(pdfName, templateName);
            String requestBody = objectMapper.writeValueAsString(payload);


//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(uri)
//                    .header("Content-Type", "application/json")
//                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("username", username)
                    .header("password", password)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            logHttpRequest(request);
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            logHttpResponse(response);

            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                PdfResponseTO pdfResponse = objectMapper.readValue(response.body(), PdfResponseTO.class);
                return ResponseEntity.status(response.statusCode()).body(pdfResponse);
            } else if (response.statusCode() >= 400 && response.statusCode() < 500) {
                throw new AppException("Invalid credentials to generate the pdf, Please Register to Pomfret Console", HttpStatus.UNAUTHORIZED);
            } else {
                throw new AppException("Failed to generate PDF: " + response.body(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (IOException e) {
            throw new AppException("Failed to generate PDF", HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AppException("Failed to generate PDF", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<byte[]> getPdf(String pdfName) {
        if (pdfName == null || pdfName.trim().isEmpty()) {
            throw new AppException("PdfName must not be null or empty", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            URI uri = buildGetPdfUri(pdfName);


            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("username", username)
                    .header("password", password)
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            logHttpRequest(request);
            HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());
            logHttpResponse(response);

            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                return ResponseEntity.status(response.statusCode()).body(response.body());
            }
            else if (response.statusCode() >= 400 && response.statusCode() < 500) {
                throw new AppException("Invalid credentials to GET the pdf, Please Register to Pomfret Console", HttpStatus.UNAUTHORIZED);
            }
            else {
                throw new AppException("Failed to retrieve PDF: " + new String(response.body(), StandardCharsets.UTF_8), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (IOException e) {
            throw new AppException("Failed to retrieve PDF", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AppException("Failed to retrieve PDF", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
