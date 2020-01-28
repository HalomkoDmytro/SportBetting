package com.epam.training.service.implTest;

import com.epam.training.dao.PlayerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTestDataImplTest {

    @Mock
    private PlayerDao userDao;

    @InjectMocks
    private UserServiceTestDataImpl userServiceTestData;

    @Test
    public void byId_returnOptionalPlayer() {
//
//        Optional<Player> expect = of(new Player());
//        when(userDao.playerById(anyLong())).thenReturn(expect);
//
//        Optional<Player> result = userServiceTestData.byId(0);
//
//        assertEquals(result, expect);
    }
}