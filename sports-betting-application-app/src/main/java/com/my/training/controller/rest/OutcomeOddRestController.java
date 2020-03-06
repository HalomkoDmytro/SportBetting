package com.my.training.controller.rest;

import com.my.training.model.outcome.OutcomeOdd;
import com.my.training.service.OutcomeOddService;
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
public class OutcomeOddRestController {

    @Autowired
    private OutcomeOddService oddService;

    @GetMapping("/outcomeOdds")
    public List<OutcomeOdd> outcomeOdds() {
        return oddService.findAll();
    }

    @GetMapping("/outcomeOdds/{id}")
    public OutcomeOdd outcomeOddOne(@PathVariable int id) {
        return oddService.findById(id);
    }

    @PostMapping(value = "/outcomeOdds", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public OutcomeOdd saveOutcomeOdd( OutcomeOdd outcomeOdd) {
        return oddService.create(outcomeOdd);
    }

}
