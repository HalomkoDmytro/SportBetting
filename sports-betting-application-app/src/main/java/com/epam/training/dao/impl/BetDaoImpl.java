package com.epam.training.dao.impl;

import com.epam.training.dao.BetDaoTestData;
import com.epam.training.model.bet.Bet;
import com.epam.training.model.bet.BetType;
import com.epam.training.model.outcome.Outcome;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.sportevent.AbstractSportEvent;
import com.epam.training.service.SportEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Deprecated
public class BetDaoImpl implements BetDaoTestData {

    private SportEventsService eventsService;
    private final List<Bet> list;

    @Autowired
    public BetDaoImpl(SportEventsService sportEventsService) {
        list = new ArrayList<>();
        eventsService = sportEventsService;

    }

    @Override
    public List<Bet> getAll() {
        return list;
    }

    @Override
    public void addBet(Bet bet) {
        list.add(bet);
    }

//    @PostConstruct
    public void setTestDate() {
        final Optional<AbstractSportEvent> sportEventOptional = eventsService.byId(1);
        final AbstractSportEvent sportEvent = sportEventOptional.orElseThrow(NullPointerException::new);

        final Bet betGoals = generateBetGoals(sportEvent);
        final Bet betScore = generateBetScore(sportEvent);
        final Bet betWinner = generateBetWinner(sportEvent);

        addBet(betGoals);
        addBet(betScore);
        addBet(betWinner);
    }

    private void generateOutcome(Bet bet, float oddVal) {
        final Date startDate = bet.getEvent().getStartDate();
        final Date endDate = bet.getEvent().getEndDate();
        final OutcomeOdd outcomeOdd = new OutcomeOdd();
        outcomeOdd.setOddValue(oddVal);
        outcomeOdd.setFrom(startDate);
        outcomeOdd.setTo(endDate);
        final Outcome outcomePlayer = new Outcome();
        outcomePlayer.setOutcome("Arsenal vs Chelsea");
        outcomePlayer.addOutcomeOdd(outcomeOdd);
//        bet.addOutcomes(outcomePlayer);
        bet.setOutcome(outcomePlayer);
    }

    private Bet generateBetGoals(AbstractSportEvent sportEvent) {
        final Bet bet = new Bet();
        bet.setEvent(sportEvent);
        bet.setDescriptor("the player Oliver Giroud will score 1");
        bet.setType(BetType.GOALS);

        generateOutcome(bet, 10.0f);
        return bet;
    }

    private Bet generateBetScore(AbstractSportEvent sportEvent) {
        final Bet bet = new Bet();
        bet.setEvent(sportEvent);
        bet.setDescriptor("the number of scored goals will be 3");
        bet.setType(BetType.SCORE);

        generateOutcome(bet, 1.3f);
        return bet;
    }

    private Bet generateBetWinner(AbstractSportEvent sportEvent) {
        final Bet bet = new Bet();
        bet.setEvent(sportEvent);
        bet.setDescriptor("the winner will be Arsenal. ");
        bet.setType(BetType.WINNER);

        generateOutcome(bet, 4.0f);
        return bet;
    }
}
