package com.epam.training.service;


import com.epam.training.model.sportevent.AbstractSportEvent;
import com.epam.training.model.sportevent.Event;
import com.epam.training.model.sportevent.SportEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SportEventsService {

    Optional<AbstractSportEvent> byId(long id);

    List<? extends AbstractSportEvent> getAll();

    List<? extends AbstractSportEvent> findAllByEventType(Event event);

}
