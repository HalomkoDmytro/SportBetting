package com.epam.training.dao;

import com.epam.training.model.outcome.OutcomeOdd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutcomeOddDao extends JpaRepository<OutcomeOdd, Integer> {
}
