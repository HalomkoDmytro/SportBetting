package com.epam.training.service.impl;


import com.epam.training.dao.BetDao;
import com.epam.training.dao.impl.BetDaoImpl;
import com.epam.training.model.bet.Bet;
import com.epam.training.service.BetService;

import java.util.List;

public class BetServiceTestDataImpl implements BetService {

    private final BetDao betDao = new BetDaoImpl();

    @Override
    public List<Bet> getAll() {
        return betDao.getAll();
    }

}
