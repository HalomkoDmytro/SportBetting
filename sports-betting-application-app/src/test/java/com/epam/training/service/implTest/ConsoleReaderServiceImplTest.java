package com.epam.training.service.implTest;

import com.epam.training.service.impl.ConsoleReaderServiceImpl;
import com.epam.training.service.impl.SystemOutServiceImpl;
import com.epam.training.util.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleReaderServiceImplTest {

    @Mock
    private SystemOutServiceImpl systemOutService;

    @InjectMocks
    private ConsoleReaderServiceImpl consoleReaderService;

    @Test
    public void getLine_returnString() {

        final String text = "test console input";
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        assertEquals(text, consoleReaderService.getLine());
    }

    @Test
    public void getLine_returnTrimmedString() {

        final String text = "  test console input with redundant spaces   ";
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        final String expected = "test console input with redundant spaces";
        assertEquals(expected, consoleReaderService.getLine());
    }

    @Test
    public void getLineWithMessage_showMessage() {

        final String text = "test input";
        final String message = "test message";

        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        consoleReaderService.getLine(message);
        verify(systemOutService, times(1)).consoleWrite(message);
    }

    @Test
    public void getLineWithMessage_returnText() {
        final String text = "test console input";
        final String message = "message";
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        assertEquals(text, consoleReaderService.getLine(message));
    }

    @Test
    public void readDate_returnDate() throws ParseException {
        final String date = "1990-02-03";
        InputStream in = new ByteArrayInputStream(date.getBytes());
        System.setIn(in);

        Date dateExpected = TimeUtil.getDateFromString(date);

        assertEquals(dateExpected, consoleReaderService.readDate());
    }

    @Test
    public void readDateWithMessage_returnDate() throws ParseException {
        final String date = "1990-02-03";
        final String message = "message";
        InputStream in = new ByteArrayInputStream(date.getBytes());
        System.setIn(in);

        Date dateExpected = TimeUtil.getDateFromString(date);

        assertEquals(dateExpected, consoleReaderService.readDate(message));
    }

    @Test
    public void readNumber_returnNumber() throws ParseException {
        int expected = 1;
        final String number = String.valueOf(expected);
        InputStream in = new ByteArrayInputStream(number.getBytes());
        System.setIn(in);

        assertEquals(expected, consoleReaderService.readNumber());
    }

    @Test
    public void readNumberWithMessage_returnNumber() throws ParseException {
        int expected = 1;
        final String number = String.valueOf(expected);
        InputStream in = new ByteArrayInputStream(number.getBytes());
        System.setIn(in);

        assertEquals(expected, consoleReaderService.readNumber(anyString()));
    }

}