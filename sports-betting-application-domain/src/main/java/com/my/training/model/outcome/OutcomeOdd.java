package com.my.training.model.outcome;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

/**
 * The odd of the {@link Outcome}.
 */
@Entity
@Table(name = "outcome_odd")
@Data
@NoArgsConstructor
public class OutcomeOdd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * Stands for how many times multiplied your money that you bet on a match result if player win
     */
    @Column(name = "odd_value")
    private float oddValue;

    @Column(name = "from_date")
    private Date from;

    @Column(name = "to_date")
    private Date to;

    @ManyToOne
    private Outcome outcome;

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
