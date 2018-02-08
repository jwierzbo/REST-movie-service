package net.jwierzbo.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<Name, String> {
    public void initialize(Name constraintAnnotation) {
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !value.isEmpty() && Character.isUpperCase(value.charAt(0));
    }
}

