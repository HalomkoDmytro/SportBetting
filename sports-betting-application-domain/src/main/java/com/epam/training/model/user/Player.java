package com.epam.training.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Player who places odds
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class Player extends User {

    @Column
    private String name;

    @Column(name = "account_number")
    private long accountNumber;

    @Column
    private BigDecimal balance;

    @Column
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

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
