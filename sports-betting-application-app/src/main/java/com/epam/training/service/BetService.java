package com.epam.training.service;

import com.epam.training.model.bet.Bet;

import java.util.List;

public interface BetService {

    Bet findById(int id);

    List<Bet> getAll();

    Bet create(Bet bet);

    Bet update(Bet bet);

    void delete(Bet bet);
}
