package com.epam.training.service.impl;


import com.epam.training.dao.EventDao;
import com.epam.training.dao.impl.EventDaoImpl;
import com.epam.training.model.sportevent.SportEvent;
import com.epam.training.service.EventsService;

import java.util.List;
import java.util.Optional;

public class EventServiceTestDataImpl implements EventsService {

    private final EventDao eventDao = new EventDaoImpl();

    @Override
    public Optional<SportEvent> byId(final long id) {
        return eventDao.byId(id);
    }

    @Override
    public List<SportEvent> getAll() {
        return eventDao.getAll();
    }

}
