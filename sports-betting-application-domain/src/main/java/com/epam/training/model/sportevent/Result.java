package com.epam.training.model.sportevent;

import com.epam.training.model.outcome.OutcomeOdd;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "result")
    private List<OutcomeOdd> outcomesWinner;

    @OneToOne()
    @JoinColumn(name = "sport_even_id")
    private SportEvent sportEvent;

    public Result() {
        this.outcomesWinner = new ArrayList<>();
    }

    public void addOutcomeOdd(final OutcomeOdd outcomeOdd) {
        outcomesWinner.add(outcomeOdd);
    }
}
