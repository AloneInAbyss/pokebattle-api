package com.pokebattle.pokebattleapi.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokebattle.pokebattleapi.model.Attributes;
import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.User;
import com.pokebattle.pokebattleapi.repository.PokemonRepository;

@Service
public class PokemonService {

  @Autowired
  private PokemonRepository pokemonRepository;

  public Pokemon drawNonRepeatedPokemonFromPool(User user) {
    Pokemon pokemon;

    long number;
    do {
      final Pokemon randomizedPokemon = drawFromPokemonsPool();

      number = user.getPokemons()
        .stream()
        .filter(p -> p.getName().equals(randomizedPokemon.getName()))
        .count();
      
      pokemon = randomizedPokemon;
    } while (number != 0);

    pokemonRepository.save(pokemon);
    
    return pokemon;
  }

  private Pokemon drawFromPokemonsPool() {
    Pokemon pokemon;

    Random rand = new Random();
    int n = rand.nextInt(6);
    n += 1;

    switch (n) {
    case 1:
      pokemon = new Pokemon("Charmander", new Attributes(80, 100, 60));
      break;
    case 2:
      pokemon = new Pokemon("Charmelion", new Attributes(180, 300, 160));
      break;
    case 3:
      pokemon = new Pokemon("Charizard", new Attributes(280, 500, 260));
      break;
    case 4:
      pokemon = new Pokemon("Bulbasaur", new Attributes(200, 70, 60));
      break;
    case 5:
      pokemon = new Pokemon("Ivysaur", new Attributes(300, 180, 160));
      break;
    default:
      pokemon = new Pokemon("Venosaur", new Attributes(500, 260, 260));
      break;
    }

    return pokemon;
  }

}
