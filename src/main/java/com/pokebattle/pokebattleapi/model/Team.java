package com.pokebattle.pokebattleapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Team {

    private Long owner;

    private String slotOne;

    private String slotTwo;

    private String slotThree;
    
}
