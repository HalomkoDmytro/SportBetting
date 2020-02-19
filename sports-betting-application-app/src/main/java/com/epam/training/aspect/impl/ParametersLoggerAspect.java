package com.epam.training.aspect.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Log parameters was passed to method.
 */
@Aspect
@Component
public class ParametersLoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParametersLoggerAspect.class);

    /**
     * Log parameter(s) passed to the called method
     *
     * @param joinPoint
     */
    @Before("execution(* com.epam.training.*.*.*(..))")
    public void beforeAdvice(final JoinPoint joinPoint) {
        String args = Arrays.toString(joinPoint.getArgs());
        LOGGER.info("***{} was called with parameter {}", joinPoint.getSignature().toShortString(), args);
    }
}
