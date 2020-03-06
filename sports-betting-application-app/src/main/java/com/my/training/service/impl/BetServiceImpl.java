package com.my.training.service.impl;

import com.my.training.dao.BetDao;
import com.my.training.exception.notFound.BetNotFoundException;
import com.my.training.model.bet.Bet;
import com.my.training.model.sportevent.AbstractSportEvent;
import com.my.training.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetServiceImpl implements BetService {

    private final BetDao betDao;

    @Autowired
    public BetServiceImpl(BetDao betDao) {
        this.betDao = betDao;
    }

    @Override
    public Bet findById(int id) {
        return betDao.findById(id)
                .orElseThrow(() -> new BetNotFoundException(String.format("Bet with id %d not found.", id)));
    }

    @Override
    public List<Bet> getAll() {
        return betDao.findAll();
    }

    @Override
    public Bet create(Bet bet) {
        return betDao.save(bet);
    }

    @Override
    public Bet update(Bet bet) {
        return betDao.save(bet);
    }

    @Override
    public void delete(Bet bet) {
        betDao.delete(bet);
    }

    @Override
    public List<Bet> betsForSportEvent(AbstractSportEvent sportEvent) {
        return betsForSportEventById(sportEvent.getId());
    }

    @Override
    public List<Bet> betsForSportEventById(Integer idSportEvent) {
        return betDao.findByEventId(idSportEvent);
    }
}
