package com.epam.training.service.impl;


import com.epam.training.service.ConsoleReaderService;
import com.epam.training.ui.UiText;
import com.epam.training.util.TimeUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReaderServiceImpl implements ConsoleReaderService {

    private Scanner scanner;
    private Date date;

    public ConsoleReaderServiceImpl() {
    }

    @Override
    public String getLine() {
        scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    @Override
    public String getLine(final String message) {
        System.out.println(message);
        return getLine();
    }

    @Override
    public Date readDate() {
        scanner = new Scanner(System.in);
        return parseDate(scanner.nextLine());
    }

    @Override
    public Date readDate(final String message) {
        System.out.println(message);
        return readDate();
    }

    @Override
    public long readNumber() {
        scanner = new Scanner(System.in);
        try {
            final int i = scanner.nextInt();
            if (i <= 0) {
                return readNumber(UiText.BAD_NUMBER_FORMAT);
            } else {
                return i;
            }
        } catch (InputMismatchException e) {
            return readNumber(UiText.BAD_NUMBER_FORMAT);
        }
    }

    @Override
    public long readNumber(final String message) {
        System.out.println(message);
        return readNumber();
    }

    private Date parseDate(final String line) {
        try {
            date = TimeUtil.getDateFromString(line);
        } catch (ParseException e) {
           return parseDate(getLine(UiText.BAD_DATE_FORMAT));
        }
        return date;
    }
}
