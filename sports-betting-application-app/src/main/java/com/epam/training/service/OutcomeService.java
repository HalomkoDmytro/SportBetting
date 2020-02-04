package com.epam.training.service;

import com.epam.training.model.bet.Bet;
import com.epam.training.model.outcome.Outcome;

import java.util.List;

public interface OutcomeService {

    Outcome findById(int id);

    List<Outcome> findAll();

    Outcome create(Outcome outcome);

    Outcome update(Outcome outcome);

    void delete(Outcome outcome);

    List<Outcome> findAllWithBet(Bet bet);

    List<Outcome> findAllWithBetId(Integer betId);
}
