package com.epam.training.service.impl;

import com.epam.training.exception.BadCredentialsException;
import com.epam.training.model.user.User;
import com.epam.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

    @Autowired
    private final UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AuthenticationProviderImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userEmail = authentication.getName();
        String password = (String) authentication.getCredentials();

        final User user = userService.findUserByEmail(userEmail)
                .orElseThrow(() -> new BadCredentialsException(String.format("Can't find user with email %s", userEmail)));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Authentication failed");
        }

        final GrantedAuthority grantedAuthority = () -> user.getRole().toString();

        final UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user, password, Collections.singleton(grantedAuthority));

        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(authenticationToken);
        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
