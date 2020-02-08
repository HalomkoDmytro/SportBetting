package com.epam.training.service.impl;

import com.epam.training.dao.WagerDao;
import com.epam.training.dto.impl.WagerNewDto;
import com.epam.training.exception.notFound.WagerNotFoundException;
import com.epam.training.model.bet.Bet;
import com.epam.training.model.outcome.Outcome;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.sportevent.SportEvent;
import com.epam.training.model.user.Player;
import com.epam.training.model.wager.Wager;
import com.epam.training.service.BetService;
import com.epam.training.service.OutcomeOddService;
import com.epam.training.service.OutcomeService;
import com.epam.training.service.SportEventsService;
import com.epam.training.service.UserService;
import com.epam.training.service.WagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
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
    private final OutcomeOddService outcomeOddService;

    @Autowired
    public WagerServiceImpl(WagerDao wagerDao, SportEventsService sportEventsService, OutcomeOddService outcomeOddService,
                            UserService userService, BetService betService, OutcomeService outcomeService) {
        this.wagerDao = wagerDao;
        this.sportEventsService = sportEventsService;
        this.userService = userService;
        this.betService = betService;
        this.outcomeService = outcomeService;
        this.outcomeOddService = outcomeOddService;
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

    private Set<String> getOutcomeValues(Bet bet) {
        return bet.getOutcomes().stream().map(Outcome::getValue).collect(Collectors.toSet());
    }

    @Override
    public Wager createWager(WagerNewDto wagerNewDto) {
        final Wager wager = new Wager();
        fillWager(wagerNewDto, wager);
        return wagerDao.save(wager);
    }

    private void fillWager(WagerNewDto wagerNewDto, Wager wager) {
        final Player playerById = userService.findPlayerById(wagerNewDto.getIdPlayer());
        final OutcomeOdd outcomeOdd = outcomeOddService.findWithOutcome(wagerNewDto.getIdOutcome());

        wager.setAmount(new BigDecimal(wagerNewDto.getBetSize()));
        wager.setCurrency(playerById.getCurrency());
        wager.setPlayer(playerById);
        wager.setOutcomeOdd(outcomeOdd);
        wager.setProcessed(false);
        wager.setTimestamp(new Date());
    }

    @Override
    public List<Wager> findByPlayerId(int playerId) {
        return wagerDao.findByPlayerId(playerId);
    }
}
