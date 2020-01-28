package com.epam.training.service.implTest;


import com.epam.training.dao.BetDaoTestData;
import com.epam.training.model.bet.Bet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BetServiceTestDataImplTest {

    @Mock
    private BetDaoTestData betDao;

    @InjectMocks
    private BetServiceTestDataImpl betService;

    @Test
    public void getAll_returnAllBet() {

        final List<Bet> list = new ArrayList<>();

        final Bet testBetOne = new Bet();
        testBetOne.setDescriptor("test one");
        list.add(testBetOne);
        final Bet testBetTwo = new Bet();
        testBetTwo.setDescriptor("test two");
        list.add(testBetTwo);

        when(betDao.getAll()).thenReturn(list);

        List<Bet> allBet = betService.getAll();

        assertTrue(allBet.contains(testBetOne));
        assertTrue(allBet.contains(testBetTwo));
        assertEquals(2, allBet.size());
    }

}