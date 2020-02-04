package com.epam.training.controller.rest;

import com.epam.training.service.WagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wager")
public class WagerRestController {

    private final WagerService wagerService;

    @Autowired
    public WagerRestController(WagerService wagerService) {
        this.wagerService = wagerService;
    }

}
