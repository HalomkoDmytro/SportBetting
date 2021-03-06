package com.my.training.controller.rest;

import com.my.training.model.user.Admin;
import com.my.training.model.user.User;
import com.my.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @GetMapping("/getAdmins/{group}")
    public List<? extends Admin> getAdmins(@PathVariable String group) {
        switch (group) {
            case "all":
                return userService.findAllAdmin();
            case "football":
                return userService.findAllFootballAdmin();
            case "tenis":
                return userService.findAllTennisAdmin();
            default:
                throw new IllegalArgumentException();
        }

    }
}
