package com.epam.training.dao;

import com.epam.training.model.sportevent.SportEvent;

import java.util.List;
import java.util.Optional;

public interface EventDao {

    Optional<SportEvent> byId(long id);

    List<SportEvent> getAll();
}
