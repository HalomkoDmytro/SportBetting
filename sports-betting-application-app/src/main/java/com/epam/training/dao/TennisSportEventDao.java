package com.epam.training.dao;

import com.epam.training.model.sportevent.TennisSportEvent;
import org.springframework.data.jpa.repository.JpaRepository;

@Deprecated
public interface TennisSportEventDao extends JpaRepository<TennisSportEvent, Integer> {
}
