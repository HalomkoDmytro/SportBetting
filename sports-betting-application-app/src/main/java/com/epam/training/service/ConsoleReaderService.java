package com.epam.training.service;

import java.util.Date;

public interface ConsoleReaderService {

    String getLine();

    String getLine(String message);

    Date readDate();

    Date readDate(String message);

    long readNumber();

    long readNumber(String message);

}
