package com.my.training.service;

import com.my.training.model.outcome.OutcomeOdd;
import com.my.training.model.user.Admin;
import com.my.training.model.user.Player;
import com.my.training.model.user.User;
import com.my.training.model.usergroup.FootballAdmin;
import com.my.training.model.usergroup.TennisAdmin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    List<? extends Admin> findAllAdmin();

    List<FootballAdmin> findAllFootballAdmin();

    List<TennisAdmin> findAllTennisAdmin();

    List<Player> findAllPlayer();

    Admin findAdminById(int id);

    Player findPlayerById(int id);

    Admin findAdminByEmail(String email);

    Player findPlayerByEmail(String email);

    Admin createAdmin(Admin admin);

    Player createPlayer(Player player);

    Admin updateAdmin(Admin admin);

    Player updatePlayer(Player player);

    void deleteAdmin(Admin admin);

    void deleteUser(Player player);

    List<Player> getAllPlayersWithOutcomeOdd(OutcomeOdd outcomeOdd);

    Optional<User> findUserByEmail(String email);

    User findUserById(int id);

}
