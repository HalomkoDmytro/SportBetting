package com.my.training.model.sportevent;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sport_event")
@NoArgsConstructor
public final class SportEvent extends AbstractSportEvent {
}
