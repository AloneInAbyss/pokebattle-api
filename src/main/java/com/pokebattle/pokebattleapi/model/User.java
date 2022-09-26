package com.pokebattle.pokebattleapi.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.pokebattle.pokebattleapi.model.enums.TeamSlots;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
public class User {

    public User(String username) {
        this.username = username;
        // should generate the private token
    }
    
    private long id;

    private String username;

    private String privateToken;

    @Getter(AccessLevel.NONE)
    private List<Pokemon> pokemons;

    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(this.pokemons);
    }

    @Setter
    private HashMap<TeamSlots, Pokemon> team;

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

}
