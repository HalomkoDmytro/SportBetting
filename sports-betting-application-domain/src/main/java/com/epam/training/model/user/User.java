package com.epam.training.model.user;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User {

    protected String email;
    protected String password;
    protected boolean isEnabled;

}
