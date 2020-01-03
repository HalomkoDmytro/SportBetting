package com.epam.training.service;


import com.epam.training.model.sportevent.SportEvent;

import java.util.List;
import java.util.Optional;

public interface EventsService {

    Optional<SportEvent> byId(long id);
    List<SportEvent> getAll();

}
