package com.my.training.dao;

import com.my.training.model.user.Player;
import com.my.training.model.user.UserAbstract;
import com.my.training.model.usergroup.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerDao extends JpaRepository<Player, Integer> {

    Optional<Player> findByEmail(String email);

    List<? extends UserAbstract> findAllByRole(Role role);
}
