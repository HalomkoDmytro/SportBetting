package com.epam.training.service.impl;


import com.epam.training.dao.EventDao;
import com.epam.training.model.sportevent.SportEvent;
import com.epam.training.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceTestDataImpl implements EventsService {

    private EventDao eventDao;

    @Autowired
    public EventServiceTestDataImpl(final EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public Optional<SportEvent> byId(final long id) {
        return eventDao.byId(id);
    }

    @Override
    public List<SportEvent> getAll() {
        return eventDao.getAll();
    }

}
