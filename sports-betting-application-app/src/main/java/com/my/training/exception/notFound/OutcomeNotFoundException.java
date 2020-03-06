package com.my.training.exception.notFound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutcomeNotFoundException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(OutcomeNotFoundException.class);

    public OutcomeNotFoundException() {
        super();
    }

    public OutcomeNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public OutcomeNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }
}
