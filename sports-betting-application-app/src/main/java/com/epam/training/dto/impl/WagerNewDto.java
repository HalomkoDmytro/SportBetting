package com.epam.training.dto.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class WagerNewDto {

    private int idPlayer;
    private int idOutcome;
    private float betSize;
}
