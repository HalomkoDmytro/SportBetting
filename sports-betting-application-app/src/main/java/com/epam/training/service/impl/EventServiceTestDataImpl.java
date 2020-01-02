package com.epam.training.service.impl;



import com.epam.training.model.sportevent.FootballSportEvent;
import com.epam.training.model.sportevent.SportEvent;
import com.epam.training.service.EventsService;
import com.epam.training.ui.UiText;
import com.epam.training.util.TimeUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class EventServiceTestDataImpl implements EventsService {

    @Override
    public Optional<SportEvent> byId(final long id) {
        return Optional.of(new FootballSportEvent("Arsenal vs Chelsea ", parseDate("2016-02-03 "), parseDate("2016-02-05")));
    }

    @Override
    public List<SportEvent> getAll() {
        return listTestData();
    }

    private List<SportEvent> listTestData() {
        List<SportEvent> sportEvents = new ArrayList<>();

        sportEvents.add(new FootballSportEvent("Arsenal vs Chelsea ", parseDate("2016-02-03 "), parseDate("2016-02-05")));

        return sportEvents;
    }

    private Date parseDate(final String line) {
        try {
            return TimeUtil.getDateFromString(line);
        } catch (ParseException e) {
            return parseDate(UiText.BAD_DATE_FORMAT);
        }
    }
}
