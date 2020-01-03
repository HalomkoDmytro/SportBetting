package com.epam.training.dao.impl;

import com.epam.training.dao.WagerDao;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.user.Player;
import com.epam.training.model.wager.Wager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WagerDaoImpl implements WagerDao {

    private final Map<Wager, Player> map = new HashMap<>();

    public WagerDaoImpl(){}

    @Override
    public void createWagerForPlayer(final OutcomeOdd outcomeOdd, final Player player, final BigDecimal betAmount) {
        player.setBalance(player.getBalance().subtract(betAmount));
        final Wager wager = createWager(outcomeOdd, player, betAmount);
        map.put(wager, player);
    }

    @Override
    public List<Player> getAllPlayersWithOutcomeOdd(final OutcomeOdd outcomeOdd) {
        return map.entrySet().stream()
                .filter(pair -> pair.getKey().getOutcomeOdd().equals(outcomeOdd))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public List<Wager> getAllWagerWithOutcomeOdd(final OutcomeOdd outcomeOdd) {
        return map.keySet().stream()
                .filter(key -> key.getOutcomeOdd().equals(outcomeOdd))
                .collect(Collectors.toList());
    }

    private Wager createWager(OutcomeOdd outcomeOdd, Player player, BigDecimal betAmount) {
        final Wager wager = new Wager();
        wager.setAmount(betAmount);
        wager.setOutcomeOdd(outcomeOdd);
        wager.setTimestamp(new Date(System.currentTimeMillis()));
        wager.setPlayer(player);
        return wager;
    }
}
