package com.epam.training.controller.rest;

import com.epam.training.model.user.Admin;
import com.epam.training.model.user.Player;
import com.epam.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser/{id}")
    public Player getUser(@PathVariable int id) {
        return userService.findPlayerById(id);
    }

    @GetMapping("/getAdmins/{group}")
    public List<? extends Admin> getAdmins(@PathVariable String group) {
        switch (group){
            case "a":
                return userService.findAllFootballAdmin();
            case "t":
                return userService.findAllTennisAdmin();
            default:
                return userService.findAllAdmin();
        }
//        return userService.findAllFootballAdmin();
    }
}
