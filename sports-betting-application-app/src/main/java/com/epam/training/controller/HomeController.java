package com.epam.training.controller;

import com.epam.training.form.impl.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

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

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
