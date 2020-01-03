package com.epam.training.service;

import com.epam.training.model.user.Player;

import java.util.Optional;

public interface UserService {

    Optional<Player> byId(long id);
}
