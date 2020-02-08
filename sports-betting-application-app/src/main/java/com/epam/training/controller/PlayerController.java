package com.epam.training.controller;

import com.epam.training.model.user.Player;
import com.epam.training.model.wager.Wager;
import com.epam.training.service.UserService;
import com.epam.training.service.WagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class PlayerController {

    private final UserService userService;
    private final WagerService wagerService;

    public PlayerController(UserService userService, WagerService wagerService) {
        this.userService = userService;
        this.wagerService = wagerService;
    }

    @GetMapping("/info")
    public String getUserInfo(Model model) {
        //todo remove mock for player
        final Player playerById = userService.findPlayerById(1);
        model.addAttribute("player", playerById);
        return "user";
    }

    @GetMapping("/wagers")
    public String getWagersForUser(Model model) {
        //todo remove mock for player
        final List<Wager> wagers = wagerService.findByPlayerId(1);
        model.addAttribute("wagers", wagers);
        return "wagers-player";
    }
}
