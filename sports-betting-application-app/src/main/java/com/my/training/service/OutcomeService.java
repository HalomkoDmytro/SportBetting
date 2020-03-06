package com.my.training.service;

import com.my.training.model.bet.Bet;
import com.my.training.model.outcome.Outcome;

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
