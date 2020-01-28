package com.epam.training.dao;

import com.epam.training.model.wager.Wager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WagerDao extends JpaRepository<Wager, Integer> {
}
