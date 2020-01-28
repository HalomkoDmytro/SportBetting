package com.epam.training.model.sportevent;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "sport_event")
@NoArgsConstructor
public class TennisSportEvent extends AbstractSportEvent {

    {
        event = Event.TENNIS;
    }

    public TennisSportEvent(final String title, final Date startDate, final Date endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
