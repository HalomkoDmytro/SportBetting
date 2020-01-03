package com.epam.training.dao.impl;


import com.epam.training.dao.UserDao;
import com.epam.training.model.user.Currency;
import com.epam.training.model.user.Player;
import com.epam.training.util.Money;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;

public class UserDaoImplTest {

    private UserDao userDao;

    @Before
    public void init() {
        userDao = new UserDaoImpl();
    }

    @Test
    public void byId_returnCorrectPlayer() {
        final Player player = new Player();
        player.setName("Peter Parker");
        player.setAccountNumber(12345);
        player.setCurrency(Currency.USD);
        player.setBalance(Money.roundBigDecimal(new BigDecimal(20_000)));
        int id = 2;
        player.setId(id);

        userDao.addPlayer(player);

        Optional<Player> actual = userDao.byId(id);
        Optional<Player> expect = of(player);
        assertEquals(expect, actual);
    }

    @Test
    public void addPlayer() {
        final Player player = new Player();
        player.setName("Test Name");
        int id = 20;
        player.setId(id);

        userDao.addPlayer(player);

        Optional<Player> actual = userDao.byId(id);
        Optional<Player> expect = of(player);
        assertEquals(expect, actual);
    }
}