package com.epam.training.model.outcome;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
/**
 * The odd of the {@link Outcome}.
 */
public class OutcomeOdd {

    private long id;

    /**
     * Stands for how many times multiplied your money that you bet on a match result if player win
     */
    private float oddValue;
    private Date from;
    private Date to;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutcomeOdd that = (OutcomeOdd) o;
        return Float.compare(that.oddValue, oddValue) == 0 &&
                Objects.equals(from, that.from) &&
                Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oddValue, from, to);
    }
}
