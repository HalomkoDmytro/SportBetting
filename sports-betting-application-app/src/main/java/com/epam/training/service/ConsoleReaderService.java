package com.epam.training.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface ConsoleReaderService {

    String getLine();

    String getLine(String message);

    Date readDate();

    Date readDate(String message);

    long readNumber();

    long readNumber(String message);

}
