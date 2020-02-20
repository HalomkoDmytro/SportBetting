package com.epam.training.form.impl;

import com.epam.training.annotation.constraint.Email;
import com.epam.training.annotation.constraint.FieldMatch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldMatch(first = "password", second = "passwordConfirm", message = "Password should match.")
public class SignUpForm {

    @Email
    private String email;

    @Size(min = 6, message = "Min length 6 character!")
    private String password;

    private String passwordConfirm;
}
