package com.epam.training.model.bet;

import com.epam.training.model.outcome.Outcome;
import com.epam.training.model.sportevent.SportEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
/**
 * Bet has possible {@link Outcome},
 * outcomes can be predicted with {@link com.epam.training.model.wager.Wager}
 * by the {@link com.epam.training.model.user.Player}
 */
public class Bet {

    private SportEvent event;
    private String descriptor;
    private List<Outcome> outcomes = new ArrayList<>();
    private BetType type;

    public void addOutcome(final Outcome outcome) {
        outcomes.add(outcome);
    }

}
