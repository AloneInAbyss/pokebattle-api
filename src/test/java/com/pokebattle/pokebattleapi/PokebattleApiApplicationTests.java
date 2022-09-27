package com.pokebattle.pokebattleapi;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pokebattle.pokebattleapi.model.Attributes;
import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.User;
import com.pokebattle.pokebattleapi.repository.PokemonRepository;
import com.pokebattle.pokebattleapi.repository.UserRepository;

@SpringBootTest
class PokebattleApiApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PokemonRepository pokemonRepository;

	@Test
	public void shouldCreateUserAndPokemons() {
		Pokemon p1 = new Pokemon("Charmander", new Attributes(100, 100, 80));
		Pokemon p2 = new Pokemon("Charmelion", new Attributes(110, 150, 90));
		Pokemon p3 = new Pokemon("Bulbasaur", new Attributes(105, 50, 80));
		Pokemon p4 = new Pokemon("Ivysaur", new Attributes(120, 70, 120));
		Pokemon p5 = new Pokemon("Venusaur", new Attributes(140, 100, 140));

		pokemonRepository.save(p1);
		pokemonRepository.save(p2);
		pokemonRepository.save(p3);
		pokemonRepository.save(p4);
		pokemonRepository.save(p5);

		List<Pokemon> pokemons = new ArrayList<>();
		pokemons.add(p1);
		pokemons.add(p2);
		pokemons.add(p3);
		pokemons.add(p4);
		pokemons.add(p5);

		User user = new User("aloneinabyss", pokemons);

		userRepository.save(user);
	}

}
