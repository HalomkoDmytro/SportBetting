package com.epam.training.dao;

import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.user.Player;
import com.epam.training.model.wager.Wager;

import java.math.BigDecimal;
import java.util.List;

@Deprecated
public interface WagerDaoTestData {

    void createWagerForPlayer(OutcomeOdd outcomeOdd, Player player, BigDecimal betAmount);

    List<Player> getAllPlayersWithOutcomeOdd(OutcomeOdd outcomeOdd);

    List<Wager> getAllWagerWithOutcomeOdd(OutcomeOdd outcomeOdd);
}
