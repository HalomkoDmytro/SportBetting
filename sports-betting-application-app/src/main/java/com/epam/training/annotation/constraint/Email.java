package com.epam.training.annotation.constraint;

import com.epam.training.validator.EmailValidator;
import com.epam.training.validator.EnglishLanguageConstrainValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmailValidator.class})
public @interface Email {

    String message() default "Bad format email";

    int maxSize() default 100;

    int minSize() default 3;

    Class<? extends Payload>[] payload() default {};

    Class<?>[] groups() default {};
}
