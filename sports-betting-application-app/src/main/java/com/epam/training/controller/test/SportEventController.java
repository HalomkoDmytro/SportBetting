package com.epam.training.controller.test;

import com.epam.training.model.sportevent.SportEvent;
import com.epam.training.service.SportEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sportEvent")
public class SportEventController {

    private final SportEventsService sportEventsService;

    @Autowired
    public SportEventController(SportEventsService sportEventsService) {
        this.sportEventsService = sportEventsService;
    }

    @GetMapping("/history")
    public String getEvents(Model model) {
        final List<SportEvent> all = sportEventsService.getAll();
        System.out.println(all);
        model.addAttribute("sportEvents", all);
        return "events";
    }
}
