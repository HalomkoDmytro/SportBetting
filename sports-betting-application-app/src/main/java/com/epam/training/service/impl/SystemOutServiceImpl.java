package com.epam.training.service.impl;

import org.springframework.stereotype.Component;

@Component
@Deprecated
public class SystemOutServiceImpl {

    public SystemOutServiceImpl(){}

    public void consoleWrite(String message) {
        System.out.println(message);
    }
}
