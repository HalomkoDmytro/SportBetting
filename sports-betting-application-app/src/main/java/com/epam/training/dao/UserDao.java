package com.epam.training.dao;

import com.epam.training.model.user.Player;

import java.util.Optional;

public interface UserDao {

    Optional<Player> byId(long id);

    void addPlayer(Player player);
}
