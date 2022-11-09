package com.pokebattle.pokebattleapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokebattle.pokebattleapi.dto.PokemonDto;
import com.pokebattle.pokebattleapi.exceptions.pokebattle.PokebattleExceptionDto;
import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.User;
import com.pokebattle.pokebattleapi.service.PokemonService;
import com.pokebattle.pokebattleapi.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pokémons")
@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private UserService userService;

    @Operation(summary = "Get a new pokémon for a user")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Got a new pokémon successfully", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = PokemonDto.class)) }),
        @ApiResponse(responseCode = "202", description = "User already have all pokémons", 
            content = { @Content(mediaType = "application/json", 
              schema = @Schema(implementation = PokebattleExceptionDto.class)) }),
        @ApiResponse(responseCode = "409", description = "Pokémon draw for user still unavailable", 
            content = { @Content(mediaType = "application/json", 
              schema = @Schema(implementation = PokebattleExceptionDto.class)) }),
        @ApiResponse(responseCode = "404", description = "User not found", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = PokebattleExceptionDto.class)) }) })
    @GetMapping("/{username}")
    public ResponseEntity<PokemonDto> drawPokemon(@PathVariable String username) {
        User user = userService.getUserInfo(username);

        Pokemon pokemon = pokemonService.drawNewPokemonForUser(user);

        userService.addPokemonToUser(user, pokemon);

        PokemonDto pokemonDto = new PokemonDto(pokemon);

        return ResponseEntity.ok(pokemonDto);
    }

}
