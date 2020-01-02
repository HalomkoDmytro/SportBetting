package com.epam.training.model.outcome;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Possible outcome of a bet
 */
@Getter
@Setter
public class Outcome {

    private String outcome = "-";
    private List<OutcomeOdd> outcomeOddList = new ArrayList<>();

    public void addOutcomeOdd(final OutcomeOdd outcomeOdd) {
        outcomeOddList.add(outcomeOdd);
    }

    @Override
    public String toString() {
        return "Outcome{" +
                "winner='" + outcome + '\'' +
                ", list=" + outcomeOddList +
                '}';
    }
}
