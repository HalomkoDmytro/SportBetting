package com.epam.training.dto.impl;

import com.epam.training.model.bet.BetType;
import com.epam.training.model.sportevent.Event;
import com.epam.training.model.user.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class WagerDto {

    private int eventId;

    private String eventTitle;

    private String startDate;

    private String endDate;

    private Event eventType;

    private BigDecimal amount;

    private Currency currency;

    private Set<BetType> outcomeOptions;

}
