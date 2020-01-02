package com.epam.training.model.sportevent;

import com.epam.training.model.outcome.OutcomeOdd;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Result {

    private List<OutcomeOdd> outcomesWinner = new ArrayList<>();

    public void addOutcomeOdd(final OutcomeOdd outcomeOdd) {
        outcomesWinner.add(outcomeOdd);
    }
}
