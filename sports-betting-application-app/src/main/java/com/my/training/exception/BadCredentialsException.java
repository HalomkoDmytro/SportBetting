package com.my.training.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;

public class BadCredentialsException extends AuthenticationException {

    private static final Logger LOGGER = LoggerFactory.getLogger(BadCredentialsException.class);

    public BadCredentialsException(String message) {
        super(message);
    }

    public BadCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }
}
