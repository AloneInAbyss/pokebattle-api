package com.pokebattle.pokebattleapi.dto;

import java.util.List;

import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.User;

import lombok.Getter;

@Getter
public class UserDto {

  public UserDto(User user) {
    this.username = user.getUsername();
    this.pokemons= user.getPokemons();
  }

  private String username;
  private List<Pokemon> pokemons;

}
