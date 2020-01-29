package com.epam.training.exception.notFound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WagerNotFoundException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(WagerNotFoundException.class);

    public WagerNotFoundException() {
        super();
    }

    public WagerNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public WagerNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }
}
