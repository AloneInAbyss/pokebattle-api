package com.pokebattle.pokebattleapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokebattle.pokebattleapi.dto.battle.BattleResultDto;

@RestController
@RequestMapping("/battle")
public class BattleController {
    
    @GetMapping("/{username}/{opponent}")
    public ResponseEntity<BattleResultDto> startBattle(@PathVariable String username, @PathVariable String opponent) {
        return ResponseEntity.ok(null);
    }

}
