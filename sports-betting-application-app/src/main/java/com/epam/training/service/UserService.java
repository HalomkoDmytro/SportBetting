package com.epam.training.service;

import com.epam.training.model.user.Admin;
import com.epam.training.model.user.Player;
import com.epam.training.model.user.User;
import com.epam.training.model.usergroup.FootballAdmin;
import com.epam.training.model.usergroup.TennisAdmin;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
