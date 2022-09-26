package com.pokebattle.pokebattleapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Attributes {

    private Long owner;

    private String hp;

    private String attack;

    private String defense;
    
}
