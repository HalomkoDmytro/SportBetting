package com.epam.training.service;

import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.user.Player;
import com.epam.training.model.wager.Wager;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface WagerService {

    Wager save(Wager wager);

    List<Wager> getAllWithOutcomeOdd(OutcomeOdd outcomeOdd);

    List<Wager> getAll();

    Wager getById(int id);

    Wager update(Wager wager);

    void deleteWager(Wager wager);
}
