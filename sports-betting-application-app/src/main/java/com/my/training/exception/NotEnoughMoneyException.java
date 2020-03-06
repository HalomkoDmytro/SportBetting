package com.my.training.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotEnoughMoneyException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotEnoughMoneyException.class);

    public NotEnoughMoneyException() {
        super();
    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }

    public NotEnoughMoneyException(String message, Throwable cause) {
        super(message, cause);
    }
}
