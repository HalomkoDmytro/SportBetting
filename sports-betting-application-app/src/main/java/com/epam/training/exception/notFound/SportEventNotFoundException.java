package com.epam.training.exception.notFound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SportEventNotFoundException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportEventNotFoundException.class);

    public SportEventNotFoundException() {
        super();
    }

    public SportEventNotFoundException(String message) {
        super(message);
    }

    public SportEventNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
