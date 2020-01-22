package com.epam.training.service.impl;


import com.epam.training.dao.UserDao;
import com.epam.training.model.user.Player;
import com.epam.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceTestDataImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceTestDataImpl(final  UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<Player> byId(final long id) {
        return userDao.byId(id);
    }

}
