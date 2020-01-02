package com.epam.training.model.outcome;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@ToString
/**
 * The odd of the {@link Outcome}
 */
public class OutcomeOdd {

    /**
     * Stands for how many times multiplied your money that you bet on a match result if player win
     */
    private float oddValue;
    private Date from;
    private Date to;
}
