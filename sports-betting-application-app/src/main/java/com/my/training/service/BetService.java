package com.my.training.service;

import com.my.training.model.bet.Bet;
import com.my.training.model.sportevent.AbstractSportEvent;

import java.util.List;

public interface BetService {

    Bet findById(int id);

    List<Bet> getAll();

    Bet create(Bet bet);

    Bet update(Bet bet);

    void delete(Bet bet);

    List<Bet> betsForSportEvent(AbstractSportEvent sportEvent);

    List<Bet> betsForSportEventById(Integer idSportEvent);
}
