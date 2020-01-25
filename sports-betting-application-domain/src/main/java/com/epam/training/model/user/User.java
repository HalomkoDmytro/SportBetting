package com.epam.training.model.user;


import com.epam.training.model.usergroup.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    protected String email;
    protected String password;
    protected boolean isEnabled;
    protected Role role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
