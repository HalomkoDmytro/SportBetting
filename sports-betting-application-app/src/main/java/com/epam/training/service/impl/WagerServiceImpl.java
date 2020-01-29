package com.epam.training.service.impl;

import com.epam.training.dao.WagerDao;
import com.epam.training.exception.notFound.WagerNotFoundException;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.wager.Wager;
import com.epam.training.service.WagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WagerServiceImpl implements WagerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WagerServiceImpl.class);

    private final WagerDao wagerDao;

    @Autowired
    public WagerServiceImpl(WagerDao wagerDao) {
        this.wagerDao = wagerDao;
    }

    @Override
    public Wager save(Wager wager) {
        return wagerDao.save(wager);
    }

    @Override
    public List<Wager> getAllWithOutcomeOdd(OutcomeOdd outcomeOdd) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Wager> getAll() {
        return wagerDao.findAll();
    }

    @Override
    public Wager getById(int id) {
        return wagerDao.findById(id)
                .orElseThrow(() -> new WagerNotFoundException(String.format("Wager with id %d not found", id)));
    }

    @Override
    public Wager update(Wager wager) {
        return wagerDao.save(wager);
    }

    @Override
    public void deleteWager(Wager wager) {
        wagerDao.delete(wager);
    }
}
