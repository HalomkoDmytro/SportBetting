package com.epam.training.dao;

import com.epam.training.model.sportevent.AbstractSportEvent;
import com.epam.training.model.sportevent.Event;
import com.epam.training.model.sportevent.SportEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportEventDao extends JpaRepository<SportEvent, Integer> {
    List<? extends AbstractSportEvent> findByEvent(Event event);
}
