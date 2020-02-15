package com.epam.training.controller;

import com.epam.training.form.impl.SignUpForm;
import com.epam.training.model.user.Player;
import com.epam.training.service.UserService;
import com.epam.training.service.impl.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String signUp() {
        return "signup";
    }

    @PostMapping("/registration")
    public String singUpNewPlayer(@ModelAttribute("signUpFrom") SignUpForm signUpForm,
                                  BindingResult bindingResult, Model model) {
        userValidator.validate(signUpForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        final Player player = new Player(signUpForm.getEmail(), signUpForm.getPassword());
        userService.createPlayer(player);

        return "redirect:/signin";
    }

}
