package com.epam.training.controller.test;

import com.epam.training.dao.BetDao;
import com.epam.training.dao.OutcomeDao;
import com.epam.training.dao.OutcomeOddDao;
import com.epam.training.dao.ResultDao;
import com.epam.training.dao.WagerDao;
import com.epam.training.model.bet.Bet;
import com.epam.training.model.outcome.Outcome;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.sportevent.Result;
import com.epam.training.model.sportevent.TennisSportEvent;
import com.epam.training.model.user.Admin;
import com.epam.training.model.user.Player;
import com.epam.training.model.wager.Wager;
import com.epam.training.service.TennisSportEventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
//
//    @Autowired
//    private AdminDao adminDao;
//
//    @Autowired
//    private PlayerDao playerDao;

    @Autowired
    private WagerDao wagerDao;

    @Autowired
    private OutcomeOddDao outcomeOddDao;

    @Autowired
    private OutcomeDao outcomeDao;

    @Autowired
    private TennisSportEventDao tennisSportEventDao;

    @Autowired
    private BetDao betDao;

    @Autowired
    private ResultDao resultDao;
//
//    @GetMapping("/test")
//    public String test() {
//        final List<Admin> all = adminDao.findAll();
//        System.out.println(all);
//        return "home";
//    }
//
//    @GetMapping("/user")
//    public String getUser() {
//
//        final Player user = playerDao.findById(1).orElseThrow(RuntimeException::new);
//        System.out.println(user);
//        return "home";
//    }

    @GetMapping("/wager")
    public String getWager() {

        final Wager wager = wagerDao.findById(1).orElseThrow(RuntimeException::new);
        System.out.println(wager);
        return "home";
    }

    @GetMapping("/outcome-odd")
    public String getOutcomeOdd() {
        final OutcomeOdd outcomeOdd = outcomeOddDao.findById(1).orElseThrow(RuntimeException::new);
        System.out.println(outcomeOdd);
        return "home";
    }

    @GetMapping("/outcome")
    public String getOutcome() {
        final Outcome outcome = outcomeDao.findById(1).orElseThrow(RuntimeException::new);
        System.out.println(outcome);
        return "home";
    }

    @GetMapping("/tennis-event")
    public String getTennisEvent() {
        final List<TennisSportEvent> all = tennisSportEventDao.findAll();
        System.out.println(all);
        return "home";
    }

    @GetMapping("/bet")
    public String getBet() {
        final List<Bet> all = betDao.findAll();
        System.out.println(all);
        return "home";
    }

    @GetMapping("/result")
    public String getResult() {
        final List<Result> all = resultDao.findAll();
        System.out.println(all);
        return "home";
    }
}
