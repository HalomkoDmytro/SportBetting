package com.epam.training.dao;

import com.epam.training.model.bet.Bet;

import java.util.List;

public interface BetDaoTestData {

    List<Bet> getAll();

    void addBet(Bet bet);
}
