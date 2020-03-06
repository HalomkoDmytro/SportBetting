package com.my.training.dao;

import com.my.training.model.sportevent.AbstractSportEvent;
import com.my.training.model.sportevent.Event;
import com.my.training.model.sportevent.SportEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportEventDao extends JpaRepository<SportEvent, Integer> {
    List<? extends AbstractSportEvent> findByEvent(Event event);
}
