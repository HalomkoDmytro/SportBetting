package com.epam.training.model.outcome;

import com.epam.training.model.bet.Bet;
import com.epam.training.model.sportevent.Result;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Possible outcome of a bet
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "outcome")
    private String value;

    @OneToMany(mappedBy = "outcome")
    @JsonBackReference
    private List<OutcomeOdd> outcomeOdds;

    @OneToOne()
    @JoinColumn(name = "result_id")
    private Result result;

    @ManyToOne
    @JoinColumn(name = "bet_id")
    @JsonBackReference
    private Bet bet;

    @Override
    public String toString() {
        return "Outcome{" +
                "outcome='" + value + '\'' +
                '}';
    }
}
