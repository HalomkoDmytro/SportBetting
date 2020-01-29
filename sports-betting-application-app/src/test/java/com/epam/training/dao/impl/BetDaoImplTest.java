package com.epam.training.dao.impl;


import com.epam.training.dao.BetDaoTestData;
import com.epam.training.model.bet.Bet;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BetDaoImplTest {
//
//    private final BetDaoTestData betDao = new BetDaoImpl();
//
//    @Test
//    public void getAll_returnListOfBet() {
//        Bet betOne = new Bet();
//        betOne.setDescriptor("test bet one");
//        Bet betTwo = new Bet();
//        betTwo.setDescriptor("test bet two");
//
//        List<Bet> resultListBeforeAdd = betDao.getAll();
//        final int sizeBeforeAdd = resultListBeforeAdd.size();
//
//        betDao.addBet(betOne);
//        betDao.addBet(betTwo);
//
//        List<Bet> resultList = betDao.getAll();
//
//        assertEquals(sizeBeforeAdd + 2, resultList.size());
//        assertTrue(resultList.contains(betTwo));
//        assertTrue(resultList.contains(betOne));
//    }
//
//    @Test
//    public void addBet_increasesAmountBet() {
//        List<Bet> resultListBeforeAdd = betDao.getAll();
//        final int sizeBeforeAdd = resultListBeforeAdd.size();
//
//        betDao.addBet(new Bet());
//
//        int actualSizeAfterAdd = betDao.getAll().size();
//        assertEquals(sizeBeforeAdd + 1, actualSizeAfterAdd);
//    }
}