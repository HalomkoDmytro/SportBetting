package com.epam.training.controller.rest;

import com.epam.training.model.outcome.Outcome;
import com.epam.training.service.OutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/outcome")
public class OutcomeRestController {

    private final OutcomeService outcomeService;

    @Autowired
    public OutcomeRestController(OutcomeService outcomeService) {
        this.outcomeService = outcomeService;
    }

    @GetMapping("/{betId}")
    public List<Outcome> getOutcome(@PathVariable Integer betId) {
        List<Outcome> outcomeList = outcomeService.findAllWithBetId(betId);
        return outcomeList;
    }
}
