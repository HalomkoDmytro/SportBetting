package com.epam.training.controller;

import com.epam.training.model.sportevent.AbstractSportEvent;
import com.epam.training.model.sportevent.Event;
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

    @GetMapping("/events")
    public String getEvents(Model model) {
        final List<SportEvent> all = (List<SportEvent>) sportEventsService.getAll();
        System.out.println(all);
//        model.addAttribute("sportEvents", all);
        return "home";
    }

    @GetMapping("/events/tennis")
    public String getTennisEvents() {
        final List<? extends AbstractSportEvent> allTennis = sportEventsService.findAllByEventType(Event.TENNIS);
        System.out.println(allTennis);
        return "home";
    }
}
