package com.my.training.controller.rest;

import com.my.training.model.wager.Wager;
import com.my.training.service.WagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class WagerRestServiceTest {

    @Mock
    private WagerService wagerService;

    @InjectMocks
    private WagerRestService wagerRestService;

    @Test
    public void wagers_returnListOfWagers() {
        final List<Wager> wagers = new ArrayList<>();
        final Wager wager_0 = new Wager();
        wager_0.setId(0);
        final Wager wager_1 = new Wager();
        wager_1.setId(1);
        wagers.add(wager_0);
        wagers.add(wager_1);

        when(wagerService.getAll()).thenReturn(wagers);

        final List<Wager> wagersResult = wagerRestService.wagers();

        assertThat(wagersResult.size()).isEqualTo(wagers.size());
        assertThat(wagersResult.get(0)).isEqualTo(wager_0);
        assertThat(wagersResult.get(1)).isEqualTo(wager_1);
    }

    @Test
    public void wagersOne_returnOneWager() {
        final Wager wagerExpected = new Wager();
        wagerExpected.setId(0);

        when(wagerService.getById(0)).thenReturn(wagerExpected);

        final Wager actualWager = wagerRestService.wagersOne(0);

        assertEquals(wagerExpected, actualWager);
    }

    @Test
    public void saveWager_returnSavedWager() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        final Wager wager = new Wager();
        wager.setId(0);
        when(wagerService.save(wager)).thenReturn(wager);

        final Wager actual = wagerRestService.saveWager(wager);

        assertEquals(wager, actual);
    }
}