package com.epam.training.model.sportevent;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sport_event")
@NoArgsConstructor
public final class SportEvent extends AbstractSportEvent {
}
