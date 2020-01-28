package com.epam.training.dao;

import com.epam.training.model.sportevent.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultDao extends JpaRepository<Result, Integer> {
}
