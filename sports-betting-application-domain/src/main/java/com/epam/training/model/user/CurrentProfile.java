package com.epam.training.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CurrentProfile {

    private final int id;
    private final String email;
}
