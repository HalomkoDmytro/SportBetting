package com.epam.training.service;

import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;

public interface SecurityService {

    String findLogInUsername();

    void login(String name, String password);

    void authenticateUserAndSetSession(String email, String password, HttpServletRequest request);
}
