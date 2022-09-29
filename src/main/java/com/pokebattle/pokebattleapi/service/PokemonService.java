package com.pokebattle.pokebattleapi.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.User;
import com.pokebattle.pokebattleapi.repository.PokemonRepository;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public Pokemon drawNewPokemonForUser(User user) {
        if (user.getPokemons().size() >= 151) {
            throw new RuntimeException();
        }

        boolean isAvailable = user.getLastDraw().plusMinutes(2).isBefore(LocalDateTime.now());
        if (user.getPokemons().size() >= 5 && !isAvailable) {
            throw new RuntimeException();
        }

        Pokemon pokemon;

        long number;
        do {
            Pokemon randomizedPokemon = drawRandomPokemon();
            pokemon = randomizedPokemon;

            number = user.getPokemons()
                .stream()
                .filter(p -> p.getName().equals(randomizedPokemon.getName()))
                .count();

        } while (number != 0);

        return pokemon;
    }

    public Pokemon getPokemonByNameOrId(String identifier) {
        Optional<Pokemon> pokemon;

        try {
            Long pokemonId = Long.parseLong(identifier);
            pokemon = pokemonRepository.findById(pokemonId);
        } catch (NumberFormatException e) {
            String pokemonName = identifier;
            pokemon = pokemonRepository.findByName(pokemonName);
        }

        if (pokemon.isEmpty()) {
            throw new RuntimeException();
        }

        return pokemon.get();
    }

    private Pokemon drawRandomPokemon() {
        Random rand = new Random();
        long n = rand.nextInt(151);
        n += 1;

        Optional<Pokemon> pokemon = pokemonRepository.findById(n);
        if (pokemon.isEmpty()) {
            throw new RuntimeException();
        }

        return pokemon.get();
    }

}
