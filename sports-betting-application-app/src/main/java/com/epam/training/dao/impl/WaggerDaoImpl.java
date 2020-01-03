package com.epam.training.dao.impl;

import com.epam.training.dao.WaggerDao;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.user.Player;
import com.epam.training.model.wager.Wager;
import com.epam.training.util.TimeUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WaggerDaoImpl implements WaggerDao {

    private final Map<Wager, Player> map = new HashMap<>();

    public WaggerDaoImpl(){}

    @Override
    public void createWagerForPlayer(OutcomeOdd outcomeOdd, Player player, BigDecimal betAmount) {
        player.setBalance(player.getBalance().subtract(betAmount));
        final Wager wager = new Wager();
        wager.setAmount(betAmount);
        wager.setOutcomeOdd(outcomeOdd);
        wager.setTimestamp(TimeUtil.getCurrentTimeStamp());
        wager.setPlayer(player);
        map.put(wager, player);
    }

    @Override
    public List<Player> getAllPlayersWithOutcomeOdd(OutcomeOdd outcomeOdd) {
        return map.entrySet().stream()
                .filter(pair -> pair.getKey().getOutcomeOdd().equals(outcomeOdd))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public List<Wager> getAllWagerWithOutcomeOdd(OutcomeOdd outcomeOdd) {
        return map.keySet().stream()
                .filter(key -> key.getOutcomeOdd().equals(outcomeOdd))
                .collect(Collectors.toList());
    }
}
