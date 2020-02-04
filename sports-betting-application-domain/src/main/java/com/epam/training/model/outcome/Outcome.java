package com.epam.training.model.outcome;

import com.epam.training.model.bet.Bet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Possible outcome of a bet
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "outcome")
    private String value;

    @OneToMany(mappedBy = "outcome")
    private List<OutcomeOdd> outcomeOdds;

    @ManyToOne
    @JoinColumn(name = "bet_id")
    @JsonBackReference
    private Bet bet;

    public Outcome() {
        this.outcomeOdds = new ArrayList<>();
    }

    public void addOutcomeOdd(final OutcomeOdd outcomeOdd) {
        outcomeOdds.add(outcomeOdd);
    }

    @Override
    public String toString() {
        return "Outcome{" +
                "outcome='" + value + '\'' +
                ", list=" + outcomeOdds +
                '}';
    }
}
