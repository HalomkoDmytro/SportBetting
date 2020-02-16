package com.epam.training.controller;

import com.epam.training.form.impl.SignUpForm;
import com.epam.training.model.user.Player;
import com.epam.training.service.SecurityService;
import com.epam.training.service.UserService;
import com.epam.training.service.impl.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/security")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;


    @GetMapping("/registration")
    public String signUp(SignUpForm signUpForm) {
        return "signup";
    }

    @PostMapping("/registration")
    public String singUpNewPlayer(@Valid SignUpForm signUpForm,
                                  BindingResult bindingResult, Model model, HttpServletRequest request) {
        userValidator.validate(signUpForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        final String email = signUpForm.getEmail();
        final Player player = new Player(email, signUpForm.getPassword());
        userService.createPlayer(player);

        securityService.authenticateUserAndSetSession(email, signUpForm.getPassword(), request);
        return "redirect:/sportEvent/history";
    }

}
