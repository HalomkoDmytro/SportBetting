package com.epam.training.dao.impl;

import com.epam.training.dao.WagerDaoTestData;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.user.Player;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class WagerDaoImplTest {

    private WagerDaoTestData wagerDao;
    private OutcomeOdd outcomeOddOne;
    private OutcomeOdd outcomeOddTwo;
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void init() {
        wagerDao = new WagerDaoImpl();

        outcomeOddOne = new OutcomeOdd();
        outcomeOddOne.setId(0);
        outcomeOddOne.setOddValue(100);

        playerOne = new Player();
        playerOne.setBalance(new BigDecimal(1000));
        playerOne.setId(0);

        outcomeOddTwo= new OutcomeOdd();
        outcomeOddTwo.setId(1);
        outcomeOddTwo.setOddValue(200);

        playerTwo = new Player();
        playerTwo.setBalance(new BigDecimal(2000));
        playerTwo.setId(1);

        wagerDao.createWagerForPlayer(outcomeOddOne, playerOne, new BigDecimal(100));
        wagerDao.createWagerForPlayer(outcomeOddTwo, playerTwo, new BigDecimal(50));
    }

    @Test
    public void createWagerForPlayer() {
//        Player testPlayer = new Player();
//        testPlayer.setId(100);
//        testPlayer.setBalance(new BigDecimal(500));
//
//        OutcomeOdd testOutcomeOdd = new OutcomeOdd();
//        testOutcomeOdd.setId(10);
//        testOutcomeOdd.setOddValue(10);
//
//        wagerDao.createWagerForPlayer(testOutcomeOdd, testPlayer, new BigDecimal(50));
//
//        List<Wager> allWagerWithOutcomeOdd = wagerDao.getAllWagerWithOutcomeOdd(testOutcomeOdd);
//        Player actualPlayer = allWagerWithOutcomeOdd.get(0).getPlayer();
//        OutcomeOdd actualOutcome = allWagerWithOutcomeOdd.get(0).getOutcomeOdds();
//
//        assertEquals(testPlayer, actualPlayer);
//        assertEquals(testOutcomeOdd, actualOutcome);
    }

    @Test
    public void getAllPlayersWithOutcomeOdd() {
        List<Player> actual = wagerDao.getAllPlayersWithOutcomeOdd(outcomeOddTwo);

        assertTrue(actual.contains(playerTwo));
        assertEquals(1, actual.size());
    }

    @Test
    public void getAllWagerWithOutcomeOdd() {
//        List<Wager> actual = wagerDao.getAllWagerWithOutcomeOdd(outcomeOddOne);
//
//        assertEquals(1, actual.size());
//        OutcomeOdd outcomeOddActual = actual.get(0).getOutcomeOdds();
//        assertEquals(outcomeOddOne, outcomeOddActual);
    }
}