package com.epam.training.service.impl;

import com.epam.training.dao.SportEventDao;
import com.epam.training.model.sportevent.AbstractSportEvent;
import com.epam.training.model.sportevent.Event;
import com.epam.training.model.sportevent.FootballSportEvent;
import com.epam.training.model.sportevent.SportEvent;
import com.epam.training.model.sportevent.TennisSportEvent;
import com.epam.training.service.SportEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public List<SportEvent> getAll() {
        return sportEventDao.findAll();
    }

    @Override
    public List<TennisSportEvent> getAllTennisSportEvents() {
        return (List<TennisSportEvent>)sportEventDao.findByEvent(Event.TENNIS);
    }

    @Override
    public List<FootballSportEvent> getAllFootballEvents() {
        return null;
    }

    @Override
    public SportEvent createSportEvent(SportEvent sportEvent) {
        return null;
    }

    @Override
    public SportEvent update(SportEvent sportEvent) {
        return null;
    }

    @Override
    public void delete(SportEvent sportEvent) {

    }
}
