package com.epam.training.dao.impl;


import com.epam.training.dao.EventDao;
import com.epam.training.model.sportevent.FootballSportEvent;
import com.epam.training.model.sportevent.SportEvent;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EventDaoImplTest {

    private EventDao eventDao;

    @Before
    public void init() {
        eventDao = new EventDaoImpl();
    }

    @Test
    public void byId() {
        final FootballSportEvent event = new FootballSportEvent("Arsenal vs Chelsea ", null, null);
        final int id = 2;
        event.setId(id);
        eventDao.addEvent(event);

        final Optional<SportEvent> actual = eventDao.byId(id);
        final Optional<FootballSportEvent> expected = Optional.of(event);
        assertEquals(expected, actual);
    }

    @Test
    public void getAll_returnAllEvents() {
        final int currentSize = eventDao.getAll().size();

        final FootballSportEvent event = new FootballSportEvent("Arsenal vs Chelsea ", null, null);
        final int id = 2;
        event.setId(id);
        eventDao.addEvent(event);

        final List<SportEvent> actual = eventDao.getAll();

        assertEquals(currentSize + 1, actual.size());
        assertTrue(actual.contains(event));
    }

    @Test
    public void addEvent() {
        final FootballSportEvent event = new FootballSportEvent("Arsenal vs Chelsea ", null, null);
        final int id = 2;

        eventDao.addEvent(event);
        final List<SportEvent> all = eventDao.getAll();

        assertTrue(all.contains(event));
    }
}