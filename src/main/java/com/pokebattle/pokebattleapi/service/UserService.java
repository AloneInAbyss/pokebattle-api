package com.pokebattle.pokebattleapi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokebattle.pokebattleapi.exceptions.pokebattle.PokebattleException;
import com.pokebattle.pokebattleapi.exceptions.pokebattle.PokebattleExceptionCodes;
import com.pokebattle.pokebattleapi.form.TeamForm;
import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.Team;
import com.pokebattle.pokebattleapi.model.User;
import com.pokebattle.pokebattleapi.repository.TeamRepository;
import com.pokebattle.pokebattleapi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PokemonService pokemonService;

    public User createUser(String username) {

        if (checkIfUserExists(username)) {
            throw new PokebattleException(PokebattleExceptionCodes.USER_ALREADY_EXISTS);
        }

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
            throw new PokebattleException(PokebattleExceptionCodes.USER_NOT_FOUND);
        }

        return user.get();
    }

    public Team changeUserPokemonTeam(String username, TeamForm teamForm) {
        User user = this.getUserInfo(username);

        List<String> pokemonsIdentifiers = List.of(teamForm.getFirst(), teamForm.getSecond(), teamForm.getThird());
        List<Long> uniquePokemons = new ArrayList<>();

        List<Pokemon> pokemons = pokemonsIdentifiers.stream().map(p -> {
            Pokemon slot = pokemonService.getPokemonByNameOrId(p);
            checkIfPokemonIsOwnedByUser(user, slot);

            uniquePokemons.forEach(id -> {
                if (slot.getId().equals(id)) {
                    throw new PokebattleException(PokebattleExceptionCodes.TEAM_REPEATED_POKEMON);
                }
            });
            uniquePokemons.add(slot.getId());

            return slot;
        }).collect(Collectors.toList());
        
        Team newTeam = new Team(pokemons.get(0), pokemons.get(1), pokemons.get(2));
        
        user.setTeam(newTeam);
        
        teamRepository.save(newTeam);
        userRepository.save(user);

        return newTeam;
    }

    public void addPokemonToUser(User user, Pokemon pokemon) {
        List<Pokemon> pokemons = user.getPokemons();

        pokemons.add(pokemon);

        user.setLastDraw(LocalDateTime.now());

        userRepository.save(user);
    }

    private void checkIfPokemonIsOwnedByUser(User user, Pokemon pokemon) {
        long owned = user.getPokemons()
            .stream()
            .filter(p -> p.getName().equals(pokemon.getName()))
            .count();
        
        if (owned != 1) {
            throw new PokebattleException(PokebattleExceptionCodes.USER_UNOWNED_POKEMON);
        }
    }

    private boolean checkIfUserExists(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        return user.isPresent();
    }

}
