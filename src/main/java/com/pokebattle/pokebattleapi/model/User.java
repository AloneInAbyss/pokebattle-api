package com.pokebattle.pokebattleapi.model;

import java.util.HashMap;
import java.util.List;

import com.pokebattle.pokebattleapi.model.enums.TeamSlots;

import lombok.Getter;

@Getter
public class User {

    public User(String username) {
        this.username = username;
    }
    
    private long id;

    private String username;

    private String privateToken;

    private List<Pokemon> pokemons;

    private HashMap<TeamSlots, Pokemon> team;

}
