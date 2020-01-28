package com.epam.training.service.implTest;


import com.epam.training.dao.EventDao;
import com.epam.training.model.sportevent.AbstractSportEvent;
import com.epam.training.model.sportevent.Event;
import com.epam.training.service.SportEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Deprecated  //--------------------------
@Service
public class EventServiceTestDataImpl implements SportEventsService {

    private EventDao eventDao;

    @Autowired
    public EventServiceTestDataImpl(final EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public Optional<AbstractSportEvent> byId(final long id) {
        return eventDao.byId(id);
    }

    @Override
    public List<AbstractSportEvent> getAll() {
        return eventDao.getAll();
    }

    @Override
    public List<AbstractSportEvent> findAllByEventType(Event event) {
        return null;
    }
}
