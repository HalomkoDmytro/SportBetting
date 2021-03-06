package com.my.training.dao;

import com.my.training.model.wager.Wager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WagerDao extends JpaRepository<Wager, Integer> {

    List<Wager> findByPlayerId(int playerId);

}
