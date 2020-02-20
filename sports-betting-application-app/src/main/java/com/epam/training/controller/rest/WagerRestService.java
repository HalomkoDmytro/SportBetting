package com.epam.training.controller.rest;

import com.epam.training.model.wager.Wager;
import com.epam.training.service.WagerService;
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
public class WagerRestService {

    @Autowired
    private WagerService wagerService;

    @GetMapping("/wagers")
    public List<Wager> wagers() {
        return wagerService.getAll();
    }

    @GetMapping("/wagers/{id}")
    public Wager wagersOne(@PathVariable int id) {
        return wagerService.getById(id);
    }

    @PostMapping(value = "/wagers", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Wager saveWager(Wager wager) {
        return wagerService.save(wager);
    }
}
