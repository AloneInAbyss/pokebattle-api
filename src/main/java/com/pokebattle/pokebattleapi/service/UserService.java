package com.pokebattle.pokebattleapi.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokebattle.pokebattleapi.dto.user.PokemonDto;
import com.pokebattle.pokebattleapi.dto.user.TeamDto;
import com.pokebattle.pokebattleapi.dto.user.UserCreationDto;
import com.pokebattle.pokebattleapi.dto.user.UserDto;
import com.pokebattle.pokebattleapi.form.TeamForm;
import com.pokebattle.pokebattleapi.form.UserForm;
import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.User;
import com.pokebattle.pokebattleapi.model.enums.TeamSlots;

@Service
public class UserService {

    @Autowired
    private PokemonService pokemonService;
    
    public UserCreationDto createUser(UserForm userForm) {
        
        User user = new User(userForm.getUsername());

        this.setDefaultPokemonTeam(user);

        return new UserCreationDto(user.getUsername(), user.getPrivateToken());

    }

    private void setDefaultPokemonTeam(User user) {

        Pokemon pokemon;
        HashMap<TeamSlots, Pokemon> team = new HashMap<>();
        
        pokemon = pokemonService.getNewPokemon();
        user.addPokemon(pokemon);
        team.put(TeamSlots.ONE, pokemon);

        pokemon = pokemonService.getNewPokemon();
        user.addPokemon(pokemon);
        team.put(TeamSlots.TWO, pokemon);

        pokemon = pokemonService.getNewPokemon();
        user.addPokemon(pokemon);
        team.put(TeamSlots.THREE, pokemon);

        user.setTeam(team);

    }

    public UserDto getUserPublicInfo(String username) {

        User user = new User(username); // should fetch data on database instead

        List<Pokemon> pokemons = user.getPokemons();
        HashMap<TeamSlots, Pokemon> team = user.getTeam();

        return new UserDto(username, pokemons, team);

    }

    public PokemonDto getNewPokemon(String token) {

        Pokemon pokemon = pokemonService.getNewPokemon();

        User user = new User(""); // should fetch data on database instead

        user.addPokemon(pokemon);

        return new PokemonDto(pokemon);

    }

    public TeamDto setNewPokemonTeam(TeamForm teamForm) {

        User user = new User(""); // should fetch data on database instead

        HashMap<TeamSlots, Pokemon> team = new HashMap<>();

        String pokemonName;
        Pokemon pokemon;

        pokemonName = teamForm.getTeam().get(1);
        pokemon = new Pokemon(pokemonName, null, null); // should fetch data on database instead
        team.put(TeamSlots.ONE, pokemon);
        
        pokemonName = teamForm.getTeam().get(2);
        pokemon = new Pokemon(pokemonName, null, null); // should fetch data on database instead
        team.put(TeamSlots.TWO, pokemon);
        
        pokemonName = teamForm.getTeam().get(3);
        pokemon = new Pokemon(pokemonName, null, null); // should fetch data on database instead
        team.put(TeamSlots.THREE, pokemon);

        user.setTeam(team);

        TeamDto teamDto = new TeamDto(team);
        
        return teamDto;

    }

}
