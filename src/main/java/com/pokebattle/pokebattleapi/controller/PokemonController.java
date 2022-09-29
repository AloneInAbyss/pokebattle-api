package com.pokebattle.pokebattleapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokebattle.pokebattleapi.dto.PokemonDto;
import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.User;
import com.pokebattle.pokebattleapi.service.PokemonService;
import com.pokebattle.pokebattleapi.service.UserService;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<PokemonDto> drawPokemon(@PathVariable String username) {
        User user = userService.getUserInfo(username);

        Pokemon pokemon = pokemonService.drawNewPokemonForUser(user);

        userService.addPokemonToUser(user, pokemon);

        PokemonDto pokemonDto = new PokemonDto(pokemon);

        return ResponseEntity.ok(pokemonDto);
    }

}
