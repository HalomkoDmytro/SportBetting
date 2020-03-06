package com.my.training.exception.notFound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetNotFoundException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(BetNotFoundException.class);

    public BetNotFoundException() {
        super();
    }

    public BetNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public BetNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }
}
