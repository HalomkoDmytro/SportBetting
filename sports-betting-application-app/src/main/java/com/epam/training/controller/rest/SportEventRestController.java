package com.epam.training.controller.rest;

import com.epam.training.model.sportevent.SportEvent;
import com.epam.training.service.SportEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class SportEventRestController {

    @Autowired
    private SportEventsService sportEventService;

    @GetMapping("/getSportEvents")
    public List<SportEvent> sportEvent() {
        return sportEventService.getAll();
    }
}
