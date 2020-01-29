package com.epam.training.service;

import com.epam.training.model.outcome.Outcome;

import java.util.List;

public interface OutcomeService {

    Outcome findById(int id);

    List<Outcome> findAll();

    Outcome create(Outcome outcome);

    Outcome update(Outcome outcome);

    void delete(Outcome outcome);
}
