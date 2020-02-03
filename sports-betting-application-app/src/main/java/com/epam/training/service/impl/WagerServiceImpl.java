package com.epam.training.service.impl;

import com.epam.training.dao.WagerDao;
import com.epam.training.dto.impl.WagerDto;
import com.epam.training.exception.notFound.WagerNotFoundException;
import com.epam.training.model.bet.Bet;
import com.epam.training.model.outcome.Outcome;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.sportevent.SportEvent;
import com.epam.training.model.user.Player;
import com.epam.training.model.wager.Wager;
import com.epam.training.service.BetService;
import com.epam.training.service.OutcomeService;
import com.epam.training.service.SportEventsService;
import com.epam.training.service.UserService;
import com.epam.training.service.WagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WagerServiceImpl implements WagerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WagerServiceImpl.class);

    private final WagerDao wagerDao;
    private final SportEventsService sportEventsService;
    private final UserService userService;
    private final BetService betService;
    private final OutcomeService outcomeService;

    @Autowired
    public WagerServiceImpl(WagerDao wagerDao, SportEventsService sportEventsService,
                            UserService userService, BetService betService, OutcomeService outcomeService) {
        this.wagerDao = wagerDao;
        this.sportEventsService = sportEventsService;
        this.userService = userService;
        this.betService = betService;
        this.outcomeService = outcomeService;
    }

    @Override
    public Wager save(Wager wager) {
        return wagerDao.save(wager);
    }

    @Override
    public List<Wager> getAllWithOutcomeOdd(OutcomeOdd outcomeOdd) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Wager> getAll() {
        return wagerDao.findAll();
    }

    @Override
    public Wager getById(int id) {
        return wagerDao.findById(id)
                .orElseThrow(() -> new WagerNotFoundException(String.format("Wager with id %d not found", id)));
    }

    @Override
    public Wager update(Wager wager) {
        return wagerDao.save(wager);
    }

    @Override
    public void deleteWager(Wager wager) {
        wagerDao.delete(wager);
    }

    @Override
    public WagerDto createWagerDto(int eventId) {
        final SportEvent sportEvent = sportEventsService.byId(eventId);
        final Player playerById = userService.findPlayerById(1);
        final Bet bet = betService.findById(eventId);
        final WagerDto wagerDto = new WagerDto();

        setStaticWagerData(sportEvent, wagerDto, playerById);

        final Set<String> outcomeValues = getOutcomeValues(bet);

        wagerDto.setOutcomeOptions(outcomeValues);

        return wagerDto;
    }

    private Set<String> getOutcomeValues(Bet bet) {
        return bet.getOutcomes().stream().map(Outcome::getValue).collect(Collectors.toSet());
    }

    private void setStaticWagerData(SportEvent sportEvent, WagerDto wagerDto, Player player) {
        wagerDto.setEventId(sportEvent.getId());
        wagerDto.setEventTitle(sportEvent.getTitle());
        wagerDto.setStartDate(sportEvent.getStartDate().toString());
        wagerDto.setEndDate(sportEvent.getEndDate().toString());
        wagerDto.setEventType(sportEvent.getEvent());
        wagerDto.setCurrency(player.getCurrency());
    }
}
