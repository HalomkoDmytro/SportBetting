package com.epam.training.service.implTest;

import com.epam.training.dao.EventDao;
import com.epam.training.model.sportevent.FootballSportEvent;
import com.epam.training.model.sportevent.AbstractSportEvent;
import com.epam.training.model.sportevent.TennisSportEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTestDataImplTest {

    @Mock
    private EventDao eventDao;

    @InjectMocks
    private EventServiceTestDataImpl eventService;

    @Test
    public void byId_returnOptionalSportEvent() {

        Optional<AbstractSportEvent> optional = of(new TennisSportEvent("test", null, null));

        when(eventDao.byId(anyLong())).thenReturn(optional);

        assertEquals(optional, eventService.byId(1));
    }

    @Test
    public void findAll_returnAllSportEvents() {
        final List<AbstractSportEvent> list = new ArrayList<>();

        TennisSportEvent tennis = new TennisSportEvent("test", null, null);
        list.add(tennis);
        FootballSportEvent football = new FootballSportEvent("test", null, null);
        list.add(football);

        when(eventDao.getAll()).thenReturn(list);

        List<AbstractSportEvent> all = eventService.getAll();

        assertEquals(2, all.size());
        assertTrue(all.contains(tennis));
        assertTrue(all.contains(football));
    }

}