package com.epam.training.service;

import com.epam.training.model.bet.Bet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BetService {

    List<Bet> getAll();

}
