package com.epam.training.controller;

import com.epam.training.form.impl.WagerNewDto;
import com.epam.training.model.bet.Bet;
import com.epam.training.model.sportevent.SportEvent;
import com.epam.training.model.user.CurrentProfile;
import com.epam.training.model.user.Player;
import com.epam.training.service.BetService;
import com.epam.training.service.SportEventsService;
import com.epam.training.service.UserService;
import com.epam.training.service.WagerService;
import com.epam.training.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WagerController {

    private final WagerService wagerService;
    private final BetService betService;
    private final SportEventsService sportEventsService;
    private final UserService userService;

    @Autowired
    public WagerController(WagerService wagerService, BetService betService,
                           SportEventsService sportEventsService, UserService userService) {
        this.wagerService = wagerService;
        this.betService = betService;
        this.sportEventsService = sportEventsService;
        this.userService = userService;
    }

    @GetMapping("/wagerNew/{idSportEvent}")
    public String getBet(@PathVariable int idSportEvent, Model model) {
        final SportEvent sportEvent = sportEventsService.byId(idSportEvent);
        List<Bet> bets = betService.betsForSportEventById(idSportEvent);

        final CurrentProfile currentProfile = SecurityUtils.getCurrentProfile();
        if(currentProfile == null) {
            return "redirect:/signin";
        }
        final Player player = userService.findPlayerById(currentProfile.getId());

        model.addAttribute("sportEvent", sportEvent);
        model.addAttribute("bets", bets);
        model.addAttribute("player", player);
        return "wagerNew";
    }

    @PostMapping("/wagerNew")
    public String createWager(@ModelAttribute WagerNewDto wagerNewDto) {
        wagerService.createWager(wagerNewDto);
        return "redirect:/user/wagers";
    }
}
