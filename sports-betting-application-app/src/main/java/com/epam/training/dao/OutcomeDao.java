package com.epam.training.dao;

import com.epam.training.model.outcome.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutcomeDao extends JpaRepository<Outcome, Integer> {
}
