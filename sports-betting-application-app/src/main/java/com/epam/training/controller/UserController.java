package com.epam.training.controller;

import com.epam.training.model.user.Player;
import com.epam.training.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info")
    public String getUserInfo(Model model) {
        //todo remove mock for player
        final Player playerById = userService.findPlayerById(1);
        model.addAttribute("player", playerById);
        return "user";
    }
}
