package com.epam.training.controller;

import com.epam.training.dto.impl.WagerDto;
import com.epam.training.model.user.Player;
import com.epam.training.model.wager.Wager;
import com.epam.training.service.WagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WagerController {

    private final WagerService wagerService;

    @Autowired
    public WagerController(WagerService wagerService){
        this.wagerService = wagerService;
    }

    @GetMapping("/wager/{id}")
    public String getWagerById(@PathVariable int id, Model model) {
        final WagerDto wagerDto = wagerService.createWagerDto(id);
//        Player player = new Player();
//        Wager wager = new Wager();
//
//        WagerDto o = new WagerDto();
//        List<String> list = new ArrayList<>();
//        list.add("opt1");
//        list.add("opt2");
//        o.setEventTitle("Predator VS Aliens");
//        o.setOutcomeOptions(list);
        model.addAttribute("wagerDto", wagerDto);
        return "wager";
    }

    @PostMapping("/wager")
    public String addWager(@ModelAttribute WagerDto wagerDto) {
        System.out.println(wagerDto);
        return "home";
    }
}
