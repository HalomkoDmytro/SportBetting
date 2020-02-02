package com.epam.training.dto.impl;

import com.epam.training.model.sportevent.Event;
import com.epam.training.model.user.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class WagerDto {

    private int eventId;

    private String eventTitle;

    private String startDate;

    private String endDate;

    private Event eventType;

    private BigDecimal amount;

    private Currency currency;

    private List<String> outcomeOptions;


    public WagerDto() {
        outcomeOptions = new ArrayList<>();
    }
}
