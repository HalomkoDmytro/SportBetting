package com.epam.training.service.impl;


import com.epam.training.service.ConsoleReaderService;
import com.epam.training.ui.UiText;
import com.epam.training.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

@Service
public class ConsoleReaderServiceImpl implements ConsoleReaderService {

    private Scanner scanner;
    private SystemOutServiceImpl out;

    @Autowired
    public ConsoleReaderServiceImpl(SystemOutServiceImpl out) {
        this.out = out;
    }

    @Override
    public String getLine() {
        scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    @Override
    public String getLine(final String message) {
        out.consoleWrite(message);
        return getLine();
    }

    @Override
    public Date readDate() {
        scanner = new Scanner(System.in);
        return parseDate(scanner.nextLine());
    }

    @Override
    public Date readDate(final String message) {
        out.consoleWrite(message);
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
        out.consoleWrite(message);
        return readNumber();
    }

    private Date parseDate(final String line) {
        try {
            return TimeUtil.getDateFromString(line);
        } catch (ParseException e) {
            return parseDate(getLine(UiText.BAD_DATE_FORMAT));
        }
    }
}
