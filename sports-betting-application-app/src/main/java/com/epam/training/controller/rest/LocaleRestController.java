package com.epam.training.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@RestController
@RequestMapping("/")
public class LocaleRestController {

    @GetMapping("/changeLocale")
    public HttpStatus changeLocale(HttpServletRequest request, HttpServletResponse response) {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();

        if (sessionLocaleResolver.resolveLocale(request).getLanguage().equals("en")) {
            sessionLocaleResolver.setLocale(request, response, StringUtils.parseLocaleString("ru"));
        } else {
            sessionLocaleResolver.setLocale(request, response, Locale.ENGLISH);
        }
        return HttpStatus.OK;
    }
}
