package com.epam.training.service.impl;

import com.epam.training.form.impl.SignUpForm;
import com.epam.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    @Override
    public void validate(Object o, Errors errors) {
        SignUpForm userData = (SignUpForm) o;


        final boolean emailOccupied = userService.findUserByEmail(userData.getEmail()).isPresent();
        if (emailOccupied) {
            errors.rejectValue("email","error.signUpForm", "An account already exists for this email.");
            return;
        }
    }
}
