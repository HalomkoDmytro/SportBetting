package com.epam.training.service;

import com.epam.training.model.outcome.Outcome;
import com.epam.training.model.outcome.OutcomeOdd;

import java.util.List;

public interface OutcomeOddService {

    OutcomeOdd create(OutcomeOdd outcomeOdd);

    OutcomeOdd update(OutcomeOdd outcomeOdd);

    List<OutcomeOdd> findAll();

    OutcomeOdd findById(int id);

    void delete(OutcomeOdd outcomeOdd);

    OutcomeOdd findWithOutcome(int id);
}
