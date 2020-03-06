package com.my.training.service.impl;

import com.my.training.dao.OutcomeDao;
import com.my.training.exception.notFound.OutcomeOddNotFoundException;
import com.my.training.model.bet.Bet;
import com.my.training.model.outcome.Outcome;
import com.my.training.service.OutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutcomeServiceImpl implements OutcomeService {

    private final OutcomeDao outcomeDao;

    @Autowired
    public OutcomeServiceImpl(OutcomeDao outcomeDao) {
        this.outcomeDao = outcomeDao;
    }

    @Override
    public Outcome findById(int id) {
        return outcomeDao.findById(id)
                .orElseThrow(() -> new OutcomeOddNotFoundException(String.format("Outcome with id %d not found.", id)));
    }

    @Override
    public List<Outcome> findAll() {
        return outcomeDao.findAll();
    }

    @Override
    public Outcome create(Outcome outcome) {
        return outcomeDao.save(outcome);
    }

    @Override
    public Outcome update(Outcome outcome) {
        return outcomeDao.save(outcome);
    }

    @Override
    public void delete(Outcome outcome) {
        outcomeDao.delete(outcome);
    }

    @Override
    public List<Outcome> findAllWithBet(Bet bet) {
        return outcomeDao.findByBet(bet);
    }

    @Override
    public List<Outcome> findAllWithBetId(Integer betId) {
        return outcomeDao.findByBetId(betId);
    }
}
