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

import com.pokebattle.pokebattleapi.dto.UserDto;
import com.pokebattle.pokebattleapi.form.UserForm;
import com.pokebattle.pokebattleapi.model.User;
import com.pokebattle.pokebattleapi.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserForm userForm) {
        User user = userService.createUser(userForm.getUsername());

        UserDto userDto = new UserDto(user);

        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{username}/team")
    public ResponseEntity<?> changeUserPokemonTeam(@PathVariable String username) {
        return ResponseEntity.ok().build();
    }

}
