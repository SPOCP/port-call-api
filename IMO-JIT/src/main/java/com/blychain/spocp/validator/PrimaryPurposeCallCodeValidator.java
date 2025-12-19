package com.blychain.spocp.validator;

import com.blychain.spocp.enums.PrimaryPurposeOfCallCodes;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimaryPurposeCallCodeValidator implements ConstraintValidator<ValidPrimaryPurposeCallCodes, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return true;
        }
        return PrimaryPurposeOfCallCodes.isValid(value);
    }

}
