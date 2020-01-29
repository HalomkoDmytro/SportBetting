package com.epam.training.service.impl;

import com.epam.training.dao.AdminDao;
import com.epam.training.dao.PlayerDao;
import com.epam.training.exception.notFound.UserNotFoundException;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.user.Admin;
import com.epam.training.model.user.Player;
import com.epam.training.model.usergroup.FootballAdmin;
import com.epam.training.model.usergroup.Role;
import com.epam.training.model.usergroup.TennisAdmin;
import com.epam.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final PlayerDao playerDao;

    private final AdminDao adminDao;

    @Autowired
    public UserServiceImpl(PlayerDao playerDao, AdminDao adminDao) {
        this.playerDao = playerDao;
        this.adminDao = adminDao;
    }

    @Override
    public List<? extends Admin> findAllAdmin() {
        return adminDao.findAllByRole(Role.ADMINS);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<FootballAdmin> findAllFootballAdmin() {
        return (List<FootballAdmin>) adminDao.findAllByRole(Role.FOOTBALL_ADMIN);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TennisAdmin> findAllTennisAdmin() {
        return (List<TennisAdmin>) adminDao.findAllByRole(Role.TENNIS_ADMIN);
    }

    @Override
    public List<Player> findAllPlayer() {
        return (List<Player>)playerDao.findAllByRole(Role.PLAYER);
    }

    @Override
    public Admin findAdminById(int id) {
        return adminDao.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("Can't find Admin with id: %d", id)));
    }

    @Override
    public Player findPlayerById(int id) {
        return playerDao.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("Can't find User with id: %d", id)));
    }

    @Override
    public Admin findAdminByEmail(String email) {
        return adminDao.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(String.format("Can't find Admin with email: %s", email)));
    }

    @Override
    public Player findPlayerByEmail(String email) {
        return playerDao.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(String.format("Can't find Player with email: %s", email)));
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminDao.save(admin);
    }

    @Override
    public Player createPlayer(Player player) {
        return playerDao.save(player);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return adminDao.save(admin);
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerDao.save(player);
    }

    @Override
    public void deleteAdmin(Admin admin) {
        adminDao.delete(admin);
    }

    @Override
    public void deleteUser(Player player) {
        playerDao.delete(player);
    }

    @Override
    public List<Player> getAllPlayersWithOutcomeOdd(OutcomeOdd outcomeOdd) {
        throw new UnsupportedOperationException();
    }
}
