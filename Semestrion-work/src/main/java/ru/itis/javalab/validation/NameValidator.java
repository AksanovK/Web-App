package ru.itis.javalab.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.length() > 1 && s.matches(".*[A-Z].*") && s.matches(".*[a-z].*");
    }
}
