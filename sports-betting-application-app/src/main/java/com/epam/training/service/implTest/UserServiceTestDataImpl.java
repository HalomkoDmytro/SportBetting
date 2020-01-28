package com.epam.training.service.implTest;


import com.epam.training.dao.PlayerDao;
import com.epam.training.model.user.Player;
import com.epam.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceTestDataImpl implements UserService {

    private PlayerDao userDao;

    @Autowired
    public UserServiceTestDataImpl(final  PlayerDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<Player> byId(final int id) {
        return userDao.findById(id);
    }

}
