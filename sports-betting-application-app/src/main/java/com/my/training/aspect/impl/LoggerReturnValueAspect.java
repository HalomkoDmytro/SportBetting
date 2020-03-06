package com.my.training.aspect.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Log return value of method.
 */
@Aspect
@Component
public class LoggerReturnValueAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerReturnValueAspect.class);

    /**
     * Logging return value of the called method(after method execution)
     *
     * @param joinPoint
     * @param retVal
     */
    @AfterReturning(pointcut = "execution(* com.epam.training.*.*.*(..))", returning = "retVal")
    public void logMethodReturnValue(JoinPoint joinPoint, Object retVal) {
        LOGGER.info("***{} return: {}", joinPoint.getSignature().toShortString(), retVal);
    }
}
