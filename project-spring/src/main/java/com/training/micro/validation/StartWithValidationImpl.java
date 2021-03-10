package com.training.micro.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValidationImpl implements ConstraintValidator<StartWith, String> {

    private StartWith anno;

    @Override
    public void initialize(final StartWith anno) {
        this.anno = anno;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        return valueParam.startsWith(this.anno.value());
    }

}
