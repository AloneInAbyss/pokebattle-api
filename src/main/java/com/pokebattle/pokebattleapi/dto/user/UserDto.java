package com.pokebattle.pokebattleapi.dto.user;

import java.util.HashMap;
import java.util.List;

import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.enums.TeamSlots;

public class UserDto {

    private String username;
    private List<Pokemon> pokemons;
    private HashMap<TeamSlots, Pokemon> team;
    
}
