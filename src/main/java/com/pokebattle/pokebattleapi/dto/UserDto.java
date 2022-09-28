package com.pokebattle.pokebattleapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.Team;
import com.pokebattle.pokebattleapi.model.User;

import lombok.Getter;

@Getter
public class UserDto {

    public UserDto(User user) {
        this.username = user.getUsername();
        this.pokemons = user.getPokemons();
        this.team = user.getTeam();
    }

    private String username;
    private List<Pokemon> pokemons;

    @JsonInclude(Include.NON_NULL)
    private Team team;

}
