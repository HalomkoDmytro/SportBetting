package com.epam.training.service.impl;

import com.epam.training.dao.SportEventDao;
import com.epam.training.model.sportevent.AbstractSportEvent;
import com.epam.training.model.sportevent.Event;
import com.epam.training.model.sportevent.SportEvent;
import com.epam.training.service.SportEventsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SportEventServiceImpl implements SportEventsService {

    private final SportEventDao sportEventDao;

    @Autowired
    public SportEventServiceImpl(SportEventDao sportEventDao) {
        this.sportEventDao = sportEventDao;
    }

    @Override
    public Optional<AbstractSportEvent> byId(long id) {
        return Optional.empty();
    }

    @Override
    public List<? extends AbstractSportEvent> getAll() {
        return sportEventDao.findAll();
    }

    @Override
    public List<? extends AbstractSportEvent> findAllByEventType(Event event) {
        return sportEventDao.findByEvent(event);
    }
}
