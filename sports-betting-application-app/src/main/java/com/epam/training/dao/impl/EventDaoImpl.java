package com.epam.training.dao.impl;

import com.epam.training.dao.EventDao;
import com.epam.training.model.sportevent.FootballSportEvent;
import com.epam.training.model.sportevent.SportEvent;
import com.epam.training.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventDaoImpl implements EventDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventDaoImpl.class);

    private final List<SportEvent> sportEvents = new ArrayList<>();

    public EventDaoImpl() {
        init();
    }

    @Override
    public Optional<SportEvent> byId(final long id) {
        return sportEvents.stream()
                .filter(event -> event.getId() == id)
                .findFirst();
    }

    @Override
    public List<SportEvent> getAll() {
        return sportEvents;
    }

    @Override
    public void addEvent(SportEvent event) {
        sportEvents.add(event);
    }

    private void init() {
        try {
            FootballSportEvent event = new FootballSportEvent("Arsenal vs Chelsea ", TimeUtil.getDateFromString("2016-02-03 "), TimeUtil.getDateFromString("2016-02-05"));
            event.setId(1);

            addEvent(event);
        } catch (ParseException ex) {
            LOGGER.info("Problem with part date", ex);
        }
    }
}
