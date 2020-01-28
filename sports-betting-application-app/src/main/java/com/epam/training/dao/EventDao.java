package com.epam.training.dao;

import com.epam.training.model.sportevent.AbstractSportEvent;
import com.epam.training.model.sportevent.SportEvent;

import java.util.List;
import java.util.Optional;

public interface EventDao {

    Optional<AbstractSportEvent> byId(long id);

    List<AbstractSportEvent> getAll();

    void addEvent(AbstractSportEvent event);
}
