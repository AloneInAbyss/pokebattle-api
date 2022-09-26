package com.pokebattle.pokebattleapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pokemon {

    private Long id;
    
    private String name;

    private Attributes attributes;

}
