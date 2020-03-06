package com.my.training.aspect.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Perform and log execution time of method.
 */
@Aspect
@Component
public class LogExecutionTimeAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogExecutionTimeAspect.class);

    @Pointcut("execution(@com.my.training.aspect.constraints.LogExecutionTime * *.*(..))")
    public void logMethodExecutionTime() {
    }

    @Around("logMethodExecutionTime()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        Object returnVal = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        long time = end - start;

        String shortSignature = proceedingJoinPoint.getSignature().toShortString();
        LOGGER.info("***Execution time {} : {} nanoseconds.", shortSignature, time);

        return returnVal;
    }
}
