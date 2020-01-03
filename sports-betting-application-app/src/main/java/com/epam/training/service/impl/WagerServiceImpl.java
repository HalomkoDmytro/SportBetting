package com.epam.training.service.impl;


import com.epam.training.dao.WaggerDao;
import com.epam.training.dao.impl.WaggerDaoImpl;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.user.Player;
import com.epam.training.model.wager.Wager;
import com.epam.training.service.WagerService;
import com.epam.training.util.TimeUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WagerServiceImpl implements WagerService {

    private final WaggerDao waggerDao = new WaggerDaoImpl();


    @Override
    public void createWagerForPlayer(final OutcomeOdd outcomeOdd, final Player player, final BigDecimal betAmount) {
        waggerDao.createWagerForPlayer(outcomeOdd, player, betAmount);

    }

    @Override
    public List<Player> getAllPlayersWithOutcomeOdd(final OutcomeOdd outcomeOdd) {
        return waggerDao.getAllPlayersWithOutcomeOdd(outcomeOdd);
    }

    @Override
    public List<Wager> getAllWagerWithOutcomeOdd(final OutcomeOdd outcomeOdd) {
        return waggerDao.getAllWagerWithOutcomeOdd(outcomeOdd);

    }
}
