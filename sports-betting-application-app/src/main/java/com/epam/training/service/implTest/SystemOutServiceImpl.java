package com.epam.training.service.implTest;

import org.springframework.stereotype.Component;

@Component
public class SystemOutServiceImpl {

    public SystemOutServiceImpl(){}

    public void consoleWrite(String message) {
        System.out.println(message);
    }
}
