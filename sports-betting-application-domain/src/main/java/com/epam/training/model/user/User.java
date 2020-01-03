package com.epam.training.model.user;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public abstract class User {

    protected long id;
    protected String email;
    protected String password;
    protected boolean isEnabled;

}
