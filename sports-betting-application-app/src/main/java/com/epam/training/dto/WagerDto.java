package com.epam.training.dto;

import com.epam.training.model.sportevent.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
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

    private String description;

    private BigDecimal amount;

    private Currency currency;

    private List<String> outcomeOptions;

    public WagerDto() {
        outcomeOptions = new ArrayList<>();
    }
}
