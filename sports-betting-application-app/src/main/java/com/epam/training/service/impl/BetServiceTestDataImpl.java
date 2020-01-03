package com.epam.training.service.impl;


import com.epam.training.dao.BetDao;
import com.epam.training.model.bet.Bet;
import com.epam.training.service.BetService;

import java.util.List;

public class BetServiceTestDataImpl implements BetService {

    private BetDao betDao;

    public BetServiceTestDataImpl(final BetDao betDao) {
        this.betDao = betDao;
    }

    @Override
    public List<Bet> getAll() {
        return betDao.getAll();
    }

}
