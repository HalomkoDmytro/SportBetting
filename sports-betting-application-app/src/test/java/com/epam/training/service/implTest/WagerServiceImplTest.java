package com.epam.training.service.implTest;


import com.epam.training.dao.WagerDaoTestData;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.user.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WagerServiceImplTest {

    @Mock
    private WagerDaoTestData wagerDao;

    @InjectMocks
    private WagerServiceImpl wagerService;

    @Test
    public void getAllPlayersWithOutcomeOdd_returnCorrectPlayers() {
        final OutcomeOdd outcomeOdd = new OutcomeOdd();
        outcomeOdd.setOddValue(0);

        final List<Player> expectedList = new ArrayList<>();
        expectedList.add(new Player());
        expectedList.add(new Player());

        when(wagerDao.getAllPlayersWithOutcomeOdd(outcomeOdd)).thenReturn(expectedList);

        List<Player> allPlayersWithOutcomeOdd = wagerService.getAllPlayersWithOutcomeOdd(outcomeOdd);

        verify(wagerDao, times(1)).getAllPlayersWithOutcomeOdd(outcomeOdd);
        assertEquals(allPlayersWithOutcomeOdd, expectedList);
    }

    @Test
    public void getAllWagerWithOutcomeOdd_returnCorrectWagerList() {
//        final OutcomeOdd outcomeOdd = new OutcomeOdd();
//        outcomeOdd.setOddValue(0);
//
//        final Wager wagerOne = new Wager();
//        wagerOne.setOutcomeOdds(outcomeOdd);
//        final Wager wagerTwo = new Wager();
//        wagerTwo.setOutcomeOdds(outcomeOdd);
//
//        final List<Wager> expectedList = new ArrayList<>();
//        expectedList.add(wagerOne);
//        expectedList.add(wagerTwo);
//
//        when(wagerDao.getAllWagerWithOutcomeOdd(outcomeOdd)).thenReturn(expectedList);
//
//        List<Wager> allWagerWithOutcomeOdd = wagerService.getAllWagerWithOutcomeOdd(outcomeOdd);
//
//        verify(wagerDao, times(1)).getAllWagerWithOutcomeOdd(outcomeOdd);
//
//        assertTrue(allWagerWithOutcomeOdd.contains(wagerTwo));
//        assertTrue(allWagerWithOutcomeOdd.contains(wagerOne));
//        assertEquals(2, allWagerWithOutcomeOdd.size());
    }

    @Test
    public void createWagerForPlayer_makeRequestForDao() {
        wagerService.createWagerForPlayer(any(), any(), any());
        verify(wagerDao, times(1)).createWagerForPlayer(any(), any(), any());
    }

}