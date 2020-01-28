package com.epam.training.dao;

import com.epam.training.model.user.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDao extends JpaRepository<Player, Integer> {
}
