package com.my.training.model.bet;

import com.my.training.model.outcome.Outcome;
import com.my.training.model.sportevent.AbstractSportEvent;
import com.my.training.model.sportevent.SportEvent;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.my.training.model.user.Player;
import com.my.training.model.wager.Wager;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Bet has possible {@link Outcome},
 * outcomes can be predicted with {@link Wager}
 * by the {@link Player}
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(targetEntity = SportEvent.class)
    @JoinColumn(name = "sport_event_id")
    @JsonBackReference
    private AbstractSportEvent event;

    @Column
    private String description;

    @OneToMany(mappedBy = "bet")
    private List<Outcome> outcomes;

    @Column(name = "bet_type")
    @Enumerated(EnumType.STRING)
    private BetType type;

    public Bet() {
        this.outcomes = new ArrayList<>();
    }


}
