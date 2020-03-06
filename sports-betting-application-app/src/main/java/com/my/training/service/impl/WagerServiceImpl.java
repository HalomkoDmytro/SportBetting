package com.my.training.service.impl;

import com.my.training.dao.WagerDao;
import com.my.training.form.impl.WagerNewDto;
import com.my.training.exception.ExpiredTimeForActionException;
import com.my.training.exception.NotEnoughMoneyException;
import com.my.training.exception.notFound.WagerNotFoundException;
import com.my.training.model.bet.Bet;
import com.my.training.model.outcome.Outcome;
import com.my.training.model.outcome.OutcomeOdd;
import com.my.training.model.user.Player;
import com.my.training.model.wager.Wager;
import com.my.training.service.BetService;
import com.my.training.service.OutcomeOddService;
import com.my.training.service.OutcomeService;
import com.my.training.service.SportEventsService;
import com.my.training.service.UserService;
import com.my.training.service.WagerService;
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

    @Override
    public void checkDateAndDeleteWager(int id) {
        final Wager wager = getById(id);
        final Date startDate = wager.getOutcomeOdd().getOutcome().getBet().getEvent().getStartDate();
        final Date curDate = new Date();

        if (curDate.compareTo(startDate) < 0) {
            wagerDao.delete(wager);
        } else {
            throw new ExpiredTimeForActionException(String.format("Try to delete wager with id: %d after event start." +
                    " Start date: %s , try delete on: %s", id, startDate.toString(), curDate.toString()));
        }
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

        reducePlayerBalance(playerById, wagerNewDto.getBetSize());

        final float betSize = wagerNewDto.getBetSize();
        wager.setAmount(new BigDecimal(betSize));
        wager.setCurrency(playerById.getCurrency());
        wager.setPlayer(playerById);
        wager.setOutcomeOdd(outcomeOdd);
        wager.setProcessed(false);
        wager.setTimestamp(new Date());
    }

    private void reducePlayerBalance(Player player, float betSize) {
        final BigDecimal bet = new BigDecimal(betSize);
        final BigDecimal playerBalance = player.getBalance();
        if (playerBalance.compareTo(bet) >= 0) {
            final BigDecimal newPlayerBalance = playerBalance.subtract(bet);
            player.setBalance(newPlayerBalance);
        } else {
            throw new NotEnoughMoneyException(String.format("Not enough money to make bet on payerId: %d, curBalance: %s, betSize: %f",
                    player.getId(), playerBalance.toString(), betSize));
        }
    }

    @Override
    public List<Wager> findByPlayerId(int playerId) {
        return wagerDao.findByPlayerId(playerId);
    }
}
