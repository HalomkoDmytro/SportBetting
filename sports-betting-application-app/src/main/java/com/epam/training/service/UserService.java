package com.epam.training.service;

import com.epam.training.model.user.Player;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    Optional<Player> byId(long id);
}
