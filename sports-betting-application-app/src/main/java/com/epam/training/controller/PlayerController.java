package com.epam.training.controller;

import com.epam.training.form.impl.PlayerPersonalInfoUpdateForm;
import com.epam.training.model.user.CurrentProfile;
import com.epam.training.model.user.Player;
import com.epam.training.model.wager.Wager;
import com.epam.training.service.UserService;
import com.epam.training.service.WagerService;
import com.epam.training.util.TimeUtil;
import com.epam.training.utils.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Date;
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
        final CurrentProfile currentProfile = SecurityUtils.getCurrentProfile();
        if(currentProfile == null) {
            return "redirect:/signin";
        }
        final Player player = userService.findPlayerById(currentProfile.getId());
        model.addAttribute("player", player);
        return "user";
    }

    @GetMapping("/wagers")
    public String getWagersForUser(Model model) {
        final CurrentProfile currentProfile = SecurityUtils.getCurrentProfile();
        if(currentProfile == null) {
            return "redirect:/signin";
        }
        final List<Wager> wagers = wagerService.findByPlayerId(currentProfile.getId());
        final Date curDate = new Date();
        model.addAttribute("wagers", wagers);
        model.addAttribute("curDate", curDate);
        return "wagers-player";
    }

    @PostMapping("/deleteWager")
    public String deleteWager(@RequestParam(name = "wagerId") int wagerId, Model model) {
        wagerService.checkDateAndDeleteWager(wagerId);
        return "redirect:/user/wagers";
    }

    @GetMapping("/user_edit")
    public String userEdit(Model model) {
        final CurrentProfile currentProfile = SecurityUtils.getCurrentProfile();
        if(currentProfile == null) {
            return "redirect:/signin";
        }
        final Player player = userService.findPlayerById(currentProfile.getId());
        model.addAttribute("player", player);
        return "user_edit";
    }

    @PostMapping("/user_edit")
    public String userEditSave(@ModelAttribute PlayerPersonalInfoUpdateForm player, Model model) throws ParseException {
        final CurrentProfile currentProfile = SecurityUtils.getCurrentProfile();
        if(currentProfile == null) {
            return "redirect:/signin";
        }
        final Player oldPlayer = userService.findPlayerById(currentProfile.getId());
        oldPlayer.setName(player.getName());
        oldPlayer.setDateOfBirth(TimeUtil.getDateFromString(player.getDateOfBirth()));

        userService.updatePlayer(oldPlayer);
        return "redirect:/user/info";
    }
}
