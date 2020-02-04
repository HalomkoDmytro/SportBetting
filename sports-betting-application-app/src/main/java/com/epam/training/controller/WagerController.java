package com.epam.training.controller;

import com.epam.training.dao.SportEventDao;
import com.epam.training.dto.impl.WagerDto;
import com.epam.training.model.bet.Bet;
import com.epam.training.model.sportevent.SportEvent;
import com.epam.training.service.BetService;
import com.epam.training.service.WagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class WagerController {

    private final WagerService wagerService;
    private final BetService betService;
    private final SportEventDao sportEventDao;

    @Autowired
    public WagerController(WagerService wagerService, BetService betService, SportEventDao sportEventDao) {
        this.wagerService = wagerService;
        this.betService = betService;
        this.sportEventDao = sportEventDao;
    }


    @GetMapping("/wagerNew/{id}")
    public String getBet(@PathVariable int idSportEvent, Model model) {
        Optional<SportEvent> sportEvent = sportEventDao.findById(idSportEvent);
        List<Bet> bets = betService.betsForSportEventById(idSportEvent);
        model.addAttribute("sportEvent", sportEventDao);
        model.addAttribute("bets", bets);
        return "wagerNew";
    }

    @GetMapping("/wager/{id}")
    public String getWagerById(@PathVariable int id, Model model) {
        final WagerDto wagerDto = wagerService.createWagerDto(id);
        model.addAttribute("wagerDto", wagerDto);
        return "wager";
    }

    @PostMapping("/wager")
    public String addWager(@ModelAttribute WagerDto wagerDto) {
        System.out.println(wagerDto);
        return "home";
    }
}
