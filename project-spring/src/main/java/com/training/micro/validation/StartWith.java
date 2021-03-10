package com.training.micro.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Retention(RUNTIME)
@Target({
          TYPE,
          FIELD,
          METHOD
})
@Constraint(validatedBy = {
                            StartWithValidationImpl.class
})
public @interface StartWith {

    String value();

    String message() default "String bununla başlamıyor";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
