package com.my.training.exception.notFound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultNotFoundException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultNotFoundException.class);

    public ResultNotFoundException() {
        super();
    }

    public ResultNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public ResultNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }
}
