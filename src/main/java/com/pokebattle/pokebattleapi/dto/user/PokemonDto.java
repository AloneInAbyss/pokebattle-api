package com.pokebattle.pokebattleapi.dto.user;

import java.util.HashMap;

import com.pokebattle.pokebattleapi.model.enums.StatTypes;

public class PokemonDto {

    private String name;
    private Long id;
    private HashMap<StatTypes, Integer> stats;
    
}
