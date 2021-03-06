package com.my.training.service.impl;

import com.my.training.exception.BadCredentialsException;
import com.my.training.model.user.User;
import com.my.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
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
