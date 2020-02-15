package com.epam.training.controller;

import com.epam.training.form.impl.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/signup")
    public String signUp(SignUpForm signUpForm) {
        return "signup";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
