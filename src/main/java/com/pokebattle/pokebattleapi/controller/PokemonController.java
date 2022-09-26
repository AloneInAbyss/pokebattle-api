package com.pokebattle.pokebattleapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @GetMapping("/{username}")
    public ResponseEntity<?> drawPokemon(@PathVariable String username) {
        return ResponseEntity.ok().build();
    }

}
