package com.my.training.controller.rest;

import com.my.training.model.sportevent.SportEvent;
import com.my.training.service.SportEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class SportEventRestController {

    @Autowired
    private SportEventsService sportEventService;

    @GetMapping("/sportEvents")
    public List<SportEvent> sportEvent() {
        return sportEventService.getAll();
    }

    @GetMapping("/sportEvents/{id}")
    public SportEvent sportEventOne(@PathVariable int id) {
        return sportEventService.byId(id);
    }

    @PostMapping(value = "/sportEvents", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public SportEvent sportEventOneSave( SportEvent sportEvent) {
        return sportEventService.createSportEvent(sportEvent);
    }

    @DeleteMapping("/sportEvents/{id}")
    public HttpStatus deleteSportEventOne(@PathVariable int id) {
        sportEventService.deleteById(id);
        return HttpStatus.OK;
    }
}
