package com.epam.training.controller;

import com.epam.training.dto.WagerDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WagerController {

    public WagerController(){}

    @GetMapping("/wager")
    public String getWager(Model model) {
        WagerDto o = new WagerDto();
        List<String> list = new ArrayList<>();
        list.add("opt1");
        list.add("opt2");
        o.setEventTitle("Predator VS Aliens");
        o.setOutcomeOptions(list);
        model.addAttribute("wagerDto", o);
        return "wager";
    }

    @PostMapping("/wager")
    public String addWager(@ModelAttribute WagerDto wagerDto) {
        System.out.println(wagerDto);
        return "home";
    }
}
