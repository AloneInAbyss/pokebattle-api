package com.pokebattle.pokebattleapi.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    
    private long id;

    private String username;

    private List<Pokemon> pokemons;

    private Team team;

}
