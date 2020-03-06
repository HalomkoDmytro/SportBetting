package com.my.training.controller;

import com.my.training.form.impl.WagerNewDto;
import com.my.training.model.bet.Bet;
import com.my.training.model.sportevent.SportEvent;
import com.my.training.model.user.CurrentProfile;
import com.my.training.model.user.Player;
import com.my.training.service.BetService;
import com.my.training.service.SportEventsService;
import com.my.training.service.UserService;
import com.my.training.service.WagerService;
import com.my.training.utils.SecurityUtils;
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
