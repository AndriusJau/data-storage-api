package com.avalanchelabs.datastorageapi.exceptions;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomDateValidator implements ConstraintValidator<SinceDate, LocalDateTime> {

    private LocalDate acceptedSinceDate;

    @Override
    public void initialize(SinceDate constraintAnnotation) {
        acceptedSinceDate = LocalDate.parse(constraintAnnotation.date());
    }

    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        return value.isAfter(acceptedSinceDate.atStartOfDay());
    }
}
