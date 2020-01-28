package com.epam.training.service.implTest;


import com.epam.training.aspect.constraints.LogExecutionTime;
import com.epam.training.dao.WagerDaoTestData;
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

    private WagerDaoTestData wagerDao;

    @Autowired
    public WagerServiceImpl(final WagerDaoTestData wagerDao) {
        this.wagerDao = wagerDao;
    }

    @Override
    @LogExecutionTime
    public void createWagerForPlayer(final OutcomeOdd outcomeOdd, final Player player, final BigDecimal betAmount) {
        wagerDao.createWagerForPlayer(outcomeOdd, player, betAmount);
    }

    @Override
    @LogExecutionTime
    public List<Player> getAllPlayersWithOutcomeOdd(final OutcomeOdd outcomeOdd) {
        return wagerDao.getAllPlayersWithOutcomeOdd(outcomeOdd);
    }

    @Override
    @LogExecutionTime
    public List<Wager> getAllWagerWithOutcomeOdd(final OutcomeOdd outcomeOdd) {
        return wagerDao.getAllWagerWithOutcomeOdd(outcomeOdd);
    }
}
