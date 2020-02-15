package com.epam.training.form.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SignUpForm {

    private String email;
    private String password;
    private String passwordConfirm;
}
