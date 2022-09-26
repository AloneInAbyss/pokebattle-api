package com.pokebattle.pokebattleapi.dto.user;

import java.util.HashMap;

import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.enums.StatTypes;

import lombok.Getter;

@Getter
public class PokemonDto {

    public PokemonDto(Pokemon pokemon) {
        this.name = pokemon.getName();
        this.id = pokemon.getId();
        this.stats = pokemon.getStats();
    }
    
    private String name;
    private Long id;
    private HashMap<StatTypes, Integer> stats;
    
}
