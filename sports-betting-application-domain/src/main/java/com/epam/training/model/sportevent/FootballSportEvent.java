package com.epam.training.model.sportevent;

import java.util.Date;

public class FootballSportEvent extends AbstractSportEvent {

    {
        event = Event.FOOTBALL;
    }

    public FootballSportEvent(final String title, final Date startDate, final Date endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
