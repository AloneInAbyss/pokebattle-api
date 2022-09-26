package com.pokebattle.pokebattleapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pokebattle.pokebattleapi.dto.user.PokemonDto;
import com.pokebattle.pokebattleapi.dto.user.TeamDto;
import com.pokebattle.pokebattleapi.dto.user.UserCreationDto;
import com.pokebattle.pokebattleapi.dto.user.UserDto;
import com.pokebattle.pokebattleapi.form.TeamForm;
import com.pokebattle.pokebattleapi.form.UserForm;


@RestController("/users")
public class UserController {
    
    @PostMapping("/register")
    public ResponseEntity<UserCreationDto> registerNewUser(@RequestBody UserForm userForm) {
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> viewUser(@PathVariable String username) {
        return ResponseEntity.ok(null);
    }
    
    @GetMapping("/{token}/pokemons")
    public ResponseEntity<PokemonDto> getNewPokemon(@PathVariable String token) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{token}/team")
    public ResponseEntity<TeamDto> changeTeam(@RequestBody TeamForm teamForm) {
        return ResponseEntity.created(null).build();
    }

}
