package com.epam.training.service.implTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SystemOutServiceImplTest {

    @Mock
    private SystemOutServiceImpl systemOutService;

    @Test
    public void consoleWrite_doNothing() {
        systemOutService.consoleWrite("test");
        doNothing().when(systemOutService).consoleWrite(anyString());
    }
}