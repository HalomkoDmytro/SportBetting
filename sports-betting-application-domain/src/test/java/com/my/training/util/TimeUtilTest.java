package com.my.training.util;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TimeUtilTest {

    @Test
    public void getFormattedDate_returnCorrectDateString() {
        final Date currentDate = new Date(System.currentTimeMillis());
        final String formattedDate = TimeUtil.getFormattedDate(currentDate);
        final String[] dateSplit = formattedDate.split("-");
        final String year = dateSplit[0];
        final String month = dateSplit[1];
        final String day = dateSplit[2];

        assertEquals(4, year.length());
        assertEquals(2, month.length());
        assertEquals(2, day.length());
        assertEquals(3, dateSplit.length);
    }

    @Test
    public void getFormattedDateWithTime_returnTime() {
        final Date currentDate = new Date(System.currentTimeMillis());
        final String formattedDate = TimeUtil.getFormattedDateWithTime(currentDate);

        final String[] split = formattedDate.split(" ");

        String[] dateSplit = split[0].split("-");
        final String year = dateSplit[0];
        final String month = dateSplit[1];
        final String day = dateSplit[2];

        assertEquals(4, year.length());
        assertEquals(2, month.length());
        assertEquals(2, day.length());
        assertEquals(3, dateSplit.length);

        String[] timeSplit = split[1].split(":");
        final String hour = timeSplit[0];
        final String min = timeSplit[1];
        final String sec = timeSplit[2];

        assertEquals(2, hour.length());
        assertEquals(2, min.length());
        assertEquals(2, sec.length());
        assertEquals(3, dateSplit.length);
    }

    @Test
    public void getDateFromString_returnDate() throws ParseException {
        final String rawString = "1990-02-22";
        final Date actual = TimeUtil.getDateFromString(rawString);
        final Date expected = new SimpleDateFormat(TimeUtil.DATE_PATTERN).parse(rawString);

        assertEquals(expected, actual);
    }
}