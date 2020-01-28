package com.epam.training.model.bet;

import com.epam.training.model.outcome.Outcome;
import com.epam.training.model.sportevent.AbstractSportEvent;
import com.epam.training.model.sportevent.SportEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

/**
 * Bet has possible {@link Outcome},
 * outcomes can be predicted with {@link com.epam.training.model.wager.Wager}
 * by the {@link com.epam.training.model.user.Player}
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bet<T extends AbstractSportEvent> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(targetEntity = SportEvent.class)
    @JoinColumn(name="sport_event_id")
    private T event;

    @Column
    private String descriptor;

    @ManyToOne
    private Outcome outcome;

    @Column(name = "bet_type")
    @Enumerated(EnumType.STRING)
    private BetType type;

}
