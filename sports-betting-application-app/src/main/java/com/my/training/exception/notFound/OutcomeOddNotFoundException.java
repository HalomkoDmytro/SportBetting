package com.my.training.exception.notFound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutcomeOddNotFoundException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(OutcomeOddNotFoundException.class);

    public OutcomeOddNotFoundException() {
        super();
    }

    public OutcomeOddNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public OutcomeOddNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }
}
