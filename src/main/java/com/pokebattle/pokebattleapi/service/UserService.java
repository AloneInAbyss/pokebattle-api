package com.pokebattle.pokebattleapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.User;
import com.pokebattle.pokebattleapi.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PokemonService pokemonService;

  public User createUser(String username) {

    List<Pokemon> pokemons = new ArrayList<>();

    User user = new User(username, pokemons);

    for (int i = 1; i <= 5; i++) {
      Pokemon pokemon = pokemonService.drawNewPokemonForUser(user);
      pokemons.add(pokemon);
    }
    
    userRepository.save(user);

    return user;

  }

  public User getUserInfo(String username) {
    Optional<User> user = userRepository.findByUsername(username);

    if (user.isEmpty()) {
      throw new RuntimeException();
    }
    
    return user.get();
  }

}
