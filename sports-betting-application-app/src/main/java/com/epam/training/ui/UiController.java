package com.epam.training.ui;



import com.epam.training.model.bet.Bet;
import com.epam.training.model.outcome.Outcome;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.sportevent.Result;
import com.epam.training.model.user.Currency;
import com.epam.training.model.user.Player;
import com.epam.training.service.BetService;
import com.epam.training.service.ConsoleReaderService;
import com.epam.training.service.UserService;
import com.epam.training.service.WagerService;
import com.epam.training.service.impl.BetServiceTestDataImpl;
import com.epam.training.service.impl.ConsoleReaderServiceImpl;
import com.epam.training.service.impl.UserServiceTestDataImpl;
import com.epam.training.service.impl.WagerServiceImpl;
import com.epam.training.util.TimeUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class UiController {

    private final ConsoleReaderService in = new ConsoleReaderServiceImpl();
    private final UserService userService = new UserServiceTestDataImpl();
    private final BetService betService = new BetServiceTestDataImpl();
    private final WagerService wagerService = new WagerServiceImpl();


    public UiController() {
        init();
    }

    public void init() {
//        Player player = createPlayer();
        final Optional<Player> playerOptional = userService.byId(1);
        final Player player = playerOptional.orElseThrow(NullPointerException::new);
        greeting(player);
        takeBet(player);
        processResult();
    }

    private void processResult() {
        System.out.println(UiText.RESULTS);

        final Result result = new Result();
        generateRandomResult(result);
        notifyWinners(result);
    }

    private void notifyWinners(Result result) {
        final List<OutcomeOdd> outcomesWinner = result.getOutcomesWinner();

        outcomesWinner.stream()
                .flatMap(outcomeOdd -> wagerService.getAllWagerWithOutcomeOdd(outcomeOdd).stream())
                .forEach(wager -> wager.setIsWin(true));
    }

    private void generateRandomResult(Result result) {
        final List<Bet> bets = betService.getAll();

        final Map<Outcome, List<OutcomeOdd>> map = bets.stream()
                .flatMap(bet -> bet.getOutcomes().stream())
                .collect(Collectors.toMap(outcome -> outcome, Outcome::getOutcomeOddList));

        map.forEach((key, value) -> value.forEach(outcomeOdd -> {
            if (Math.round(Math.random()) == 1) {
                result.addOutcomeOdd(outcomeOdd);
                System.out.println(String.format(UiText.WINNER, key.getOutcome(), outcomeOdd));
            }
        }));
    }

    private void takeBet(Player player) {
        System.out.println(UiText.OUTCOME_BET_FIRST);
        Map<String, OutcomeOdd> stringOutcomeOddMap = showBetOutcomeOptions(betService.getAll());
        while (true) {

            final String line = in.getLine();
            if (line.toLowerCase().equals(UiText.QUITE)) break;

            if (stringOutcomeOddMap.containsKey(line)) {
                final OutcomeOdd outcomeOdd = stringOutcomeOddMap.get(line);
                createWager(outcomeOdd, player);
                stringOutcomeOddMap = showBetOutcomeOptions(betService.getAll());
            }

            System.out.println(UiText.OUTCOME_BET);
        }
    }

    private void createWager(OutcomeOdd outcomeOdd, Player player) {
        while (true) {
            final String line = in.getLine(UiText.ASK_HOW_MUCH_BET);
            if (line.toLowerCase().equals(UiText.QUITE)) return;

            final int simpleBetAmount = getInt(line);
            if (simpleBetAmount == -1) break;

            final BigDecimal betAmount = new BigDecimal(simpleBetAmount);

            final BigDecimal playerBalance = player.getBalance();
            if (playerBalance.compareTo(betAmount) < 0) {
                System.out.println(String.format(UiText.DONT_HAVE_ENOUGH_MONEY,
                        playerBalance.toString(), player.getCurrency()));
            } else {
                wagerService.createWagerForPlayer(outcomeOdd, player, betAmount);
                break;
            }
        }
    }

    private void greeting(Player player) {
        System.out.println(String.format("Welcome %s", player.getName()));
        System.out.println(String.format("Your balance is %s %s", player.getBalance().toString(), player.getCurrency()));
    }

    private int getInt(String s) {
        if (s.toLowerCase().equals(UiText.QUITE)) return -1;

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return (int) in.readNumber(UiText.BAD_NUMBER_FORMAT);
        }
    }

    private Player createPlayer() {
        String name = in.getLine(UiText.ASK_NAME);
        long accountNumber = in.readNumber(UiText.ASK_ACCOUNT);
        Date dateBirth = in.readDate(UiText.ASK_DATE_BORN);
        BigDecimal balance = new BigDecimal(in.readNumber(UiText.ASK_MONEY));
        Currency currency = null;
        while (currency == null) {
            currency = Currency.getCurrency(in.getLine(UiText.ASK_CURRENCY));
        }

        Player player = new Player();
        player.setName(name);
        player.setAccountNumber(accountNumber);
        player.setDateOfBirth(dateBirth);
        player.setBalance(balance);
        player.setCurrency(currency);

        return player;
    }

    public Map<String, OutcomeOdd> showBetOutcomeOptions(List<Bet> bets) {
        Map<String, OutcomeOdd> map = new HashMap<>();
        int i = 1;
        for (Bet bet : bets) {
            for (Outcome outcome : bet.getOutcomes())
                for (OutcomeOdd outcomeOdd : outcome.getOutcomeOddList()) {
                    final StringBuilder sb = new StringBuilder()
                            .append(i)
                            .append(": ")
                            .append(bet.getDescriptor())
                            .append(", ")
                            .append(bet.getDescriptor())
                            .append(", the odd on this ")
                            .append(outcomeOdd.getOddValue())
                            .append(", valid from ")
                            .append(TimeUtil.getFormattedDate(outcomeOdd.getFrom()))
                            .append(" to ")
                            .append(TimeUtil.getFormattedDate(outcomeOdd.getTo()));
                    map.put(String.valueOf(i), outcomeOdd);
                    System.out.println(sb.toString());
                    i++;
                }
        }
        return map;
    }
}
