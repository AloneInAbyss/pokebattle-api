package com.pokebattle.pokebattleapi.dto.user;

import java.util.HashMap;
import java.util.List;

import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.enums.TeamSlots;

import lombok.Getter;

@Getter
public class UserDto {

    public UserDto(String username, List<Pokemon> pokemons, HashMap<TeamSlots, Pokemon> team) {
        this.username = username;
        this.pokemons = pokemons;
        this.team = team;
    }
    
    private String username;
    private List<Pokemon> pokemons;
    private HashMap<TeamSlots, Pokemon> team;
    
}
