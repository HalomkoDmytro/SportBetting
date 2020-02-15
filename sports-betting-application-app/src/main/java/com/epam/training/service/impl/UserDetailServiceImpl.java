package com.epam.training.service.impl;

import com.epam.training.exception.BadCredentialsException;
import com.epam.training.model.user.User;
import com.epam.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final User user = userService.findUserByEmail(email)
                .orElseThrow(() -> new BadCredentialsException(String.format("Can't find user with email %s", email)));
        GrantedAuthority grantedAuthority = () -> user.getRole().toString();

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), Collections.singleton(grantedAuthority));
    }
}
