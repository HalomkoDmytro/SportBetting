package com.epam.training.model.outcome;

import com.epam.training.model.bet.Bet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Possible outcome of a bet
 */
@Entity
@Getter
@Setter
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String outcome;

    @OneToMany(mappedBy = "outcome")
    private List<OutcomeOdd> outcomeOdds;

    @OneToMany(mappedBy = "outcome")
    private Set<Bet> bet;

    public Outcome() {
        this.outcomeOdds = new ArrayList<>();
    }

    public void addOutcomeOdd(final OutcomeOdd outcomeOdd) {
        outcomeOdds.add(outcomeOdd);
    }

    @Override
    public String toString() {
        return "Outcome{" +
                "winner='" + outcome + '\'' +
                ", list=" + outcomeOdds +
                '}';
    }
}
