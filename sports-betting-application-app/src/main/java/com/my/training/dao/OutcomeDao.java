package com.my.training.dao;

import com.my.training.model.bet.Bet;
import com.my.training.model.outcome.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutcomeDao extends JpaRepository<Outcome, Integer> {

    List<Outcome> findByBet(Bet bet);

    List<Outcome> findByBetId(Integer id);
}
