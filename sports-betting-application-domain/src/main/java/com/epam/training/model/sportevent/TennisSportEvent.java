package com.epam.training.model.sportevent;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "sport_event")
public class TennisSportEvent extends AbstractSportEvent {

    public TennisSportEvent() {
        event = Event.TENNIS;
    }

    public TennisSportEvent(final String title, final Date startDate, final Date endDate) {
        this();
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
