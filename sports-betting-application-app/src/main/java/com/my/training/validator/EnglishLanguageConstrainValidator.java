package com.my.training.validator;

import com.my.training.annotation.constraint.EnglishLanguage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnglishLanguageConstrainValidator implements ConstraintValidator<EnglishLanguage, String> {

    private boolean withNumber;
    private boolean withPunctuations;
    private boolean withSpechSymbols;

    private static final String SPETCH_SYMBOLS = "~#$%^&*-+=_\\|/@`!'\";:><,.?{}";
    private static final String PUNCTUATIONS = ".,?!-:()'\\\"[]{}; \\t\\n";
    private static final String NUMBERS = "0123456789";
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public void initialize(EnglishLanguage constraintAnnotation) {
        this.withNumber = constraintAnnotation.withNumber();
        this.withSpechSymbols = constraintAnnotation.withSpechSymbols();
        this.withPunctuations = constraintAnnotation.withPunctuations();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        String validatorTemplate = getValidatorTemplate();
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (validatorTemplate.indexOf(ch) == -1) {
                return false;
            }
        }

        return true;
    }

    private String getValidatorTemplate() {
        StringBuilder template = new StringBuilder(LETTERS);

        if (withNumber) {
            template.append(NUMBERS);
        }

        if (withPunctuations) {
            template.append(PUNCTUATIONS);
        }

        if (withSpechSymbols) {
            template.append(SPETCH_SYMBOLS);
        }

        return template.toString();
    }
}
