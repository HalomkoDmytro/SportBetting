package com.epam.training.annotation.constraint;

import com.epam.training.validator.FieldMatchConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Util annotation. Checking the identity of the values of two fields.
 */
@Target({TYPE, ANNOTATION_TYPE,})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {FieldMatchConstraintValidator.class})
public @interface FieldMatch {

    String message() default "FieldMatch";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String first();

    String second();

    /**
     * Defines several <code>@FieldMatch</code> annotations on the same element
     *
     * @see FieldMatch
     */
    @Target({TYPE, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        FieldMatch[] value();
    }
}
