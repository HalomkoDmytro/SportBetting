package com.epam.training.dao;

import com.epam.training.model.bet.Bet;
import com.epam.training.model.outcome.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutcomeDao extends JpaRepository<Outcome, Integer> {

    List<Outcome> findByBet(Bet bet);

    List<Outcome> findByBetId(Integer id);
}
