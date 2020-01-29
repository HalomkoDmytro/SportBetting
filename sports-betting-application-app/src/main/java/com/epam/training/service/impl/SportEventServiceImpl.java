package com.epam.training.service.impl;

import com.epam.training.dao.SportEventDao;
import com.epam.training.exception.notFound.SportEventNotFoundException;
import com.epam.training.model.sportevent.Event;
import com.epam.training.model.sportevent.FootballSportEvent;
import com.epam.training.model.sportevent.SportEvent;
import com.epam.training.model.sportevent.TennisSportEvent;
import com.epam.training.service.SportEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportEventServiceImpl implements SportEventsService {

    private final SportEventDao sportEventDao;

    @Autowired
    public SportEventServiceImpl(SportEventDao sportEventDao) {
        this.sportEventDao = sportEventDao;
    }

    @Override
    public SportEvent byId(int id) {
        return sportEventDao.findById(id)
                .orElseThrow(() -> new SportEventNotFoundException(String.format("Sport Event with id %d not found", id)));
    }

    @Override
    public List<SportEvent> getAll() {
        return sportEventDao.findAll();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TennisSportEvent> getAllTennisSportEvents() {
        return (List<TennisSportEvent>)sportEventDao.findByEvent(Event.TENNIS);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<FootballSportEvent> getAllFootballEvents() {
        return (List<FootballSportEvent>)sportEventDao.findByEvent(Event.FOOTBALL);
    }

    @Override
    public SportEvent createSportEvent(SportEvent sportEvent) {
        return sportEventDao.save(sportEvent);
    }

    @Override
    public SportEvent update(SportEvent sportEvent) {
        return sportEventDao.save(sportEvent);
    }

    @Override
    public void delete(SportEvent sportEvent) {
        sportEventDao.delete(sportEvent);
    }
}
