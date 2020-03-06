package com.my.training.dao;

import com.my.training.model.sportevent.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultDao extends JpaRepository<Result, Integer> {
}
