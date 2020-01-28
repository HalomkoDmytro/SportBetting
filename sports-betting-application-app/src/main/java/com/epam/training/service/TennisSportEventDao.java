package com.epam.training.service;

import com.epam.training.model.sportevent.TennisSportEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TennisSportEventDao extends JpaRepository<TennisSportEvent, Integer> {
}
