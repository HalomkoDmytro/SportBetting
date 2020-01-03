package com.epam.training.service.impl;

import com.epam.training.dao.UserDao;
import com.epam.training.model.user.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTestDataImplTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceTestDataImpl userServiceTestData;

    @Test
    public void byId_returnOptionalPlayer() {

        Optional<Player> expect = of(new Player());
        when(userDao.byId(anyLong())).thenReturn(expect);

        Optional<Player> result = userServiceTestData.byId(0);

        assertEquals(result, expect);
    }
}