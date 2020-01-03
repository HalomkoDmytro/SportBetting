package com.epam.training.model.sportevent;


import com.epam.training.model.bet.Bet;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public abstract class SportEvent {

    protected long id;
    protected String title;
    protected Date startDate;
    protected Date endDate;
    @Setter(AccessLevel.NONE)
    protected Event event;

    private Result result;
    private List<Bet> betList = new ArrayList<>();

    @Override
    public String toString() {
        return "SportEvent{" +
                "title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", event=" + event +
                '}';
    }
}
