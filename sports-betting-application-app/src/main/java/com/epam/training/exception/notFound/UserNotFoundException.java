package com.epam.training.exception.notFound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserNotFoundException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserNotFoundException.class);

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }
}
