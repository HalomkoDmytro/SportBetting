package com.my.training.model.outcome;

import com.my.training.model.bet.Bet;
import com.my.training.model.sportevent.Result;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@Data
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
