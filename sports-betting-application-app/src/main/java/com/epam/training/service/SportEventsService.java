package com.epam.training.service;


import com.epam.training.model.sportevent.AbstractSportEvent;
import com.epam.training.model.sportevent.Event;
import com.epam.training.model.sportevent.FootballSportEvent;
import com.epam.training.model.sportevent.SportEvent;
import com.epam.training.model.sportevent.TennisSportEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SportEventsService {

    Optional<AbstractSportEvent> byId(long id);

    List<SportEvent> getAll();

    List<TennisSportEvent> getAllTennisSportEvents();

    List<FootballSportEvent> getAllFootballEvents();

    SportEvent createSportEvent(SportEvent sportEvent);

    SportEvent update(SportEvent sportEvent);

    void delete(SportEvent sportEvent);

}
