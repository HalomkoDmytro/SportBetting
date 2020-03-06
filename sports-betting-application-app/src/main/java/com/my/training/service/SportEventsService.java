package com.my.training.service;


import com.my.training.model.sportevent.FootballSportEvent;
import com.my.training.model.sportevent.SportEvent;
import com.my.training.model.sportevent.TennisSportEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SportEventsService {

    SportEvent byId(int id);

    List<SportEvent> getAll();

    List<TennisSportEvent> getAllTennisSportEvents();

    List<FootballSportEvent> getAllFootballEvents();

    SportEvent createSportEvent(SportEvent sportEvent);

    SportEvent update(SportEvent sportEvent);

    void delete(SportEvent sportEvent);

    void deleteById(int id);

}
