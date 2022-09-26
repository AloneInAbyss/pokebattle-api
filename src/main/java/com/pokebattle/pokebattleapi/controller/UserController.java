package com.pokebattle.pokebattleapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {
    
    @PostMapping("/register")
    public ResponseEntity<?> createUser() {
        return ResponseEntity.ok().build();
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
