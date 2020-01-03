package com.epam.training.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class SystemOutServiceImplTest {

    @Mock
    private SystemOutServiceImpl systemOutService;

    @Test
    public void consoleWrite_doNothing() {
        systemOutService.consoleWrite("test");
        doNothing().when(systemOutService).consoleWrite(anyString());
    }
}