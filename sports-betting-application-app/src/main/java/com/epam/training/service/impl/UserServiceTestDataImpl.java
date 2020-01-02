package com.epam.training.service.impl;



import com.epam.training.model.user.Currency;
import com.epam.training.model.user.Player;
import com.epam.training.service.UserService;
import com.epam.training.ui.UiText;
import com.epam.training.util.Money;
import com.epam.training.util.TimeUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

public class UserServiceTestDataImpl implements UserService {

    private Date date;

    @Override
    public Optional<Player> byId(final long id) {
        final Player player = new Player();
        player.setName("Peter Parker");
        player.setAccountNumber(12345);
        player.setCurrency(Currency.USD);
        player.setBalance(Money.roundBigDecimal(new BigDecimal(20_000)));
        player.setDateOfBirth(parseDate("1990-03-04"));

        return Optional.of(player);
    }

    private Date parseDate(final String line) {
        try {
            date = TimeUtil.getDateFromString(line);
        } catch (ParseException e) {
            return parseDate(UiText.BAD_DATE_FORMAT);
        }
        return date;
    }
}
