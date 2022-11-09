package com.pokebattle.pokebattleapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Team changeUserPokemonTeam(String username, TeamForm teamForm) {
        User user = this.getUserInfo(username);

        List<String> pokemonsIdentifiers = List.of(teamForm.getFirst(), teamForm.getSecond(), teamForm.getThird());

        List<Pokemon> pokemons = pokemonsIdentifiers.stream().map(p -> {
            Pokemon slot = pokemonService.getPokemonByNameOrId(p);
            checkIfPokemonIsOwnedByUser(user, slot);
            return slot;
        }).collect(Collectors.toList());
        
        // Team oldTeam = user.getTeam();
        Team newTeam = new Team(pokemons.get(0).getId(), pokemons.get(1).getId(), pokemons.get(2).getId());
        
        user.setTeam(newTeam);
        
        teamRepository.save(newTeam);
        userRepository.save(user);
        // teamRepository.delete(oldTeam);

        return newTeam;
    }

    private void checkIfPokemonIsOwnedByUser(User user, Pokemon pokemon) {
        long owned = user.getPokemons()
            .stream()
            .filter(p -> p.getName().equals(pokemon.getName()))
            .count();
        
        if (owned != 1) {
            throw new RuntimeException();
        }
    }

}
