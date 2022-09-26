package com.pokebattle.pokebattleapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/battle")
public class BattleController {
    
    @GetMapping("/{player1}/{player2}")
    public ResponseEntity<?> startBattle(@PathVariable String player1, @PathVariable String player2) {
        return ResponseEntity.ok().build();
    }

}
