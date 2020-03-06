package com.my.training.dao;

import com.my.training.model.outcome.OutcomeOdd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutcomeOddDao extends JpaRepository<OutcomeOdd, Integer> {

    OutcomeOdd deleteByOutcomeId(int outcomeId);
}
