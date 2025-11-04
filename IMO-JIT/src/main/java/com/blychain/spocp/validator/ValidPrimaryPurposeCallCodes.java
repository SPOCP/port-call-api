package com.blychain.spocp.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PrimaryPurposeCallCodeValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPrimaryPurposeCallCodes {
    String message() default "Invalid primaryPurposeOfCallCode";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

