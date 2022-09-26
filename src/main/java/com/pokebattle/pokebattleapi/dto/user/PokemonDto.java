package com.pokebattle.pokebattleapi.dto.user;

import java.util.HashMap;

import com.pokebattle.pokebattleapi.model.enums.StatTypes;

import lombok.Getter;

@Getter
public class PokemonDto {

    public PokemonDto(String name, Long id, HashMap<StatTypes, Integer> stats) {
        this.name = name;
        this.id = id;
        this.stats = stats;
    }
    
    private String name;
    private Long id;
    private HashMap<StatTypes, Integer> stats;
    
}
