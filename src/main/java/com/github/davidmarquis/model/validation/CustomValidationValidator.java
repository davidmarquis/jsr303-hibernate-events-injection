package com.github.davidmarquis.model.validation;


import com.github.davidmarquis.InjectableBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidationValidator implements ConstraintValidator<CustomValidation, String> {

    @Autowired
    private InjectableBean injectableBean;

    public void initialize(CustomValidation constraintAnnotation) {

    }

    public boolean isValid(String email, ConstraintValidatorContext context) {
        return injectableBean.isEmailAddressUnique(email);
    }
}
