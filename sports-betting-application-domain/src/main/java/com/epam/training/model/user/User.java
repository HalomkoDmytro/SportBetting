package com.epam.training.model.user;


import com.epam.training.model.usergroup.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    protected Integer id;

    @Column
    protected String email;

    @Column
    protected String password;

    @Column(name = "is_enabled")
    protected boolean isEnabled;

    @Column
    @Enumerated(EnumType.STRING)
    protected Role role;

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
