package com.epam.training.service.impl;


import com.epam.training.dao.WagerDao;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.user.Player;
import com.epam.training.model.wager.Wager;
import com.epam.training.service.WagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WagerServiceImpl implements WagerService {

    private WagerDao wagerDao;

    @Autowired
    public WagerServiceImpl(final WagerDao wagerDao) {
        this.wagerDao = wagerDao;
    }

    @Override
    public void createWagerForPlayer(final OutcomeOdd outcomeOdd, final Player player, final BigDecimal betAmount) {
        wagerDao.createWagerForPlayer(outcomeOdd, player, betAmount);
    }

    @Override
    public List<Player> getAllPlayersWithOutcomeOdd(final OutcomeOdd outcomeOdd) {
        return wagerDao.getAllPlayersWithOutcomeOdd(outcomeOdd);
    }

    @Override
    public List<Wager> getAllWagerWithOutcomeOdd(final OutcomeOdd outcomeOdd) {
        return wagerDao.getAllWagerWithOutcomeOdd(outcomeOdd);
    }
}
