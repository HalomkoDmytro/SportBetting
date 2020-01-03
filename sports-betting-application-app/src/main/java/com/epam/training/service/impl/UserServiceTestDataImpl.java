package com.epam.training.service.impl;


import com.epam.training.dao.UserDao;
import com.epam.training.model.user.Player;
import com.epam.training.service.UserService;

import java.util.Optional;

public class UserServiceTestDataImpl implements UserService {

    private UserDao userDao;

    public UserServiceTestDataImpl(final  UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<Player> byId(final long id) {
        return userDao.byId(id);
    }

}
