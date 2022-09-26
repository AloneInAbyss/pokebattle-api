package com.pokebattle.pokebattleapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokebattle.pokebattleapi.dto.user.PokemonDto;
import com.pokebattle.pokebattleapi.dto.user.TeamDto;
import com.pokebattle.pokebattleapi.dto.user.UserCreationDto;
import com.pokebattle.pokebattleapi.dto.user.UserDto;
import com.pokebattle.pokebattleapi.form.TeamForm;
import com.pokebattle.pokebattleapi.form.UserForm;
import com.pokebattle.pokebattleapi.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public ResponseEntity<UserCreationDto> registerNewUser(@RequestBody UserForm userForm) {
        UserCreationDto userCreationDto = userService.createUser(userForm);

        return ResponseEntity.ok(userCreationDto);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> viewUser(@PathVariable String username) {
        UserDto userDto = userService.getUserPublicInfo(username);

        return ResponseEntity.ok(userDto);
    }
    
    @GetMapping("/{token}/pokemons")
    public ResponseEntity<PokemonDto> getNewPokemon(@PathVariable String token) {
        PokemonDto pokemonDto = userService.getNewPokemon(token);

        return ResponseEntity.ok(pokemonDto);
    }

    @PutMapping("/{token}/team")
    public ResponseEntity<TeamDto> changeTeam(@RequestBody TeamForm teamForm) {
        TeamDto teamDto = userService.setNewPokemonTeam(teamForm);

        return ResponseEntity.ok(teamDto);
    }

}
