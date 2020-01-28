package com.epam.training.controller;

import com.epam.training.dao.AdminDao;
import com.epam.training.model.user.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppUiController {

    @Autowired
    private AdminDao adminDao;

    @GetMapping("/")
    public String empty() {
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/signin")
    public String sigIn() {
        return "signin";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
