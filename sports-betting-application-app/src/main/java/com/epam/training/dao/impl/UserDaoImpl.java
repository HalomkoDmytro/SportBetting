package com.epam.training.dao.impl;

import com.epam.training.dao.UserDao;
import com.epam.training.model.user.Currency;
import com.epam.training.model.user.Player;
import com.epam.training.ui.UiText;
import com.epam.training.util.Money;
import com.epam.training.util.TimeUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private final List<Player> players;

    public UserDaoImpl() {
        players = new ArrayList<>();
    }

    @Override
    public Optional<Player> byId(final long id) {
        return players.stream()
                .filter(player -> player.getId() == id)
                .findFirst();
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @PostConstruct
    public void init() {
        final Player player = new Player();
        player.setName("Peter Parker");
        player.setAccountNumber(12345);
        player.setCurrency(Currency.USD);
        player.setBalance(Money.roundBigDecimal(new BigDecimal(20_000)));
        player.setDateOfBirth(parseDate("1990-03-04"));
        player.setId(1);

        addPlayer(player);
    }

    private Date parseDate(final String line) {
        try {
            return TimeUtil.getDateFromString(line);
        } catch (ParseException e) {
            return parseDate(UiText.BAD_DATE_FORMAT);
        }
    }
}
