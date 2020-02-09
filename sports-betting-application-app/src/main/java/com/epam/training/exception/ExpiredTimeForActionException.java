package com.epam.training.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpiredTimeForActionException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpiredTimeForActionException.class);

    public ExpiredTimeForActionException() {
        super();
    }

    public ExpiredTimeForActionException(String message) {
        super(message);
    }

    public ExpiredTimeForActionException(String message, Throwable cause) {
        super(message, cause);
    }
}
