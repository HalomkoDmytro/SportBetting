package com.epam.training.dao;

import com.epam.training.model.bet.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetDao extends JpaRepository<Bet, Integer> {
}
