package com.pokebattle.pokebattleapi.dto;

import com.pokebattle.pokebattleapi.model.Attributes;
import com.pokebattle.pokebattleapi.model.Pokemon;

import lombok.Getter;

@Getter
public class PokemonDto {
    
    public PokemonDto(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.attributes = pokemon.getAttributes();
    }

    private Long id;
    private String name;
    private Attributes attributes;
    
}
