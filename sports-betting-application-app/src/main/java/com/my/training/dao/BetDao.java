package com.my.training.dao;

import com.my.training.model.bet.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BetDao extends JpaRepository<Bet, Integer> {

    @Query("SELECT b FROM Bet b WHERE b.event.id = :id")
    List<Bet> findByEventId(@Param("id") Integer id);
}
