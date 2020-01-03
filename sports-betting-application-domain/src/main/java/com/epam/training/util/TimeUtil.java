package com.epam.training.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class TimeUtil {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static String getFormattedDate(final Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
        return format.format(date);
    }

    public static String getFormattedDateWithTime(final Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_PATTERN);
        return format.format(date);
    }

    public static Date getDateFromString(final String line) throws ParseException {
        return new SimpleDateFormat(DATE_PATTERN).parse(line);
    }
}
