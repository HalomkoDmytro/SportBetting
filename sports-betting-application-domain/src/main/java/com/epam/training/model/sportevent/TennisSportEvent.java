package com.epam.training.model.sportevent;

import java.util.Date;

public class TennisSportEvent extends SportEvent {

    {
        event = Event.TENNIS;
    }

    public TennisSportEvent(final String title, final Date startDate, final Date endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
