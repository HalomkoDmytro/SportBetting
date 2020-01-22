package com.epam.training.service;


import com.epam.training.model.sportevent.SportEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EventsService {

    Optional<SportEvent> byId(long id);
    List<SportEvent> getAll();

}
