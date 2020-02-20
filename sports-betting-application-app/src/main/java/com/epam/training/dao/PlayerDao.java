package com.epam.training.dao;

import com.epam.training.model.user.Player;
import com.epam.training.model.user.UserAbstract;
import com.epam.training.model.usergroup.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerDao extends JpaRepository<Player, Integer> {

    Optional<Player> findByEmail(String email);

    List<? extends UserAbstract> findAllByRole(Role role);
}
