package com.pokebattle.pokebattleapi.dto.user;

import java.util.List;

import lombok.Getter;

@Getter
public class TeamDto {
    
    public TeamDto(List<PokemonDto> pokemons) {
        this.pokemons = pokemons;
    }

    private List<PokemonDto> pokemons;

}
