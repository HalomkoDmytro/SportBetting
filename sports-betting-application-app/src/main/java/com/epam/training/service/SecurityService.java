package com.epam.training.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityService {

    String findLogInUsername();

    void login(String name, String password);
}
