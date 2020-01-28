package com.epam.training.service.implTest;


import com.epam.training.dao.BetDaoTestData;
import com.epam.training.model.bet.Bet;
import com.epam.training.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetServiceTestDataImpl implements BetService {

    private BetDaoTestData betDao;

    @Autowired
    public BetServiceTestDataImpl(final BetDaoTestData betDao) {
        this.betDao = betDao;
    }

    @Override
    public List<Bet> getAll() {
        return betDao.getAll();
    }

}
