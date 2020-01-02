package com.epam.training.model.user;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Player who places odds
 */
@Getter
@Setter
public class Player extends User{

    private String name;
    private long accountNumber;
    private BigDecimal balance;
    private Currency currency;
    private Date dateOfBirth;

    public Player(){}

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", currency=" + currency +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
