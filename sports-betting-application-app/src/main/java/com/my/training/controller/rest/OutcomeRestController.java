package com.my.training.controller.rest;

import com.my.training.model.outcome.Outcome;
import com.my.training.service.OutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class OutcomeRestController {

    private final OutcomeService outcomeService;

    @Autowired
    public OutcomeRestController(OutcomeService outcomeService) {
        this.outcomeService = outcomeService;
    }

    @GetMapping("/outcome/{betId}")
    public List<Outcome> getOutcome(@PathVariable Integer betId) {
        List<Outcome> outcomeList = outcomeService.findAllWithBetId(betId);
        return outcomeList;
    }

    @GetMapping("/outcomes")
    public List<Outcome> getAll() {
        return outcomeService.findAll();
    }

    @GetMapping("/outcomes/{Id}")
    public Outcome getById(@PathVariable int id) {
        return outcomeService.findById(id);
    }

    @PostMapping(value = "/outcomes", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Outcome createBet(Outcome outcome) {
        return outcomeService.create(outcome);
    }
}
