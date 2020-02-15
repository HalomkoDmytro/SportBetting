package com.epam.training.service.impl;

import com.epam.training.dao.AdminDao;
import com.epam.training.dao.PlayerDao;
import com.epam.training.dao.UserDao;
import com.epam.training.exception.notFound.UserNotFoundException;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.user.Admin;
import com.epam.training.model.user.Currency;
import com.epam.training.model.user.Player;
import com.epam.training.model.user.User;
import com.epam.training.model.user.UserAbstract;
import com.epam.training.model.usergroup.FootballAdmin;
import com.epam.training.model.usergroup.Role;
import com.epam.training.model.usergroup.TennisAdmin;
import com.epam.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PlayerDao playerDao;

    private final AdminDao adminDao;

    private final UserDao userDao;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(PlayerDao playerDao, AdminDao adminDao, UserDao userDao, BCryptPasswordEncoder passwordEncoder) {
        this.playerDao = playerDao;
        this.adminDao = adminDao;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
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
    @SuppressWarnings("unchecked")
    public List<Player> findAllPlayer() {
        return (List<Player>) playerDao.findAllByRole(Role.PLAYER);
    }

    @Override
    public Admin findAdminById(int id) {
        return adminDao.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("Can't find Admin with id: %d", id)));
    }

    @Override
    public Player findPlayerById(int id) {
        return playerDao.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("Can't find Player with id: %d", id)));
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
        encodePassword(admin);
        return adminDao.save(admin);
    }

    @Override
    public Player createPlayer(Player player) {
        player.setRole(Role.PLAYER);
        encodePassword(player);
        setMockData(player);
        return playerDao.save(player);
    }

    private void setMockData(Player player) {
        player.setBalance(new BigDecimal(1000));
        player.setCurrency(Currency.EUR);
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

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User findUserById(int id) {
        return userDao.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("Can't find User with id: %d", id)));
    }

    private void encodePassword(UserAbstract userAbstract) {
        userAbstract.setPassword(passwordEncoder.encode(userAbstract.getPassword()));
    }

}
