package com.epam.training.service.impl;


import com.epam.training.dao.BetDao;
import com.epam.training.model.bet.Bet;
import com.epam.training.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetServiceTestDataImpl implements BetService {

    private BetDao betDao;

    @Autowired
    public BetServiceTestDataImpl(final BetDao betDao) {
        this.betDao = betDao;
    }

    @Override
    public List<Bet> getAll() {
        return betDao.getAll();
    }

}
