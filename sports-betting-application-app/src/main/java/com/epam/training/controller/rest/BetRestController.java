package com.epam.training.controller.rest;

import com.epam.training.model.bet.Bet;
import com.epam.training.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class BetRestController {

    @Autowired
    private BetService betService;

    @GetMapping("/bets")
    public List<Bet> bets() {
        return betService.getAll();
    }

    @GetMapping("/bets/{id}")
    public Bet betById(@PathVariable int id) {
        return betService.findById(id);
    }

    @PostMapping(value = "/bets", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Bet createBet(Bet bet) {
        return betService.create(bet);
    }

}
