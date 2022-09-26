package com.pokebattle.pokebattleapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokebattle.pokebattleapi.dto.battle.BattleResultDto;
import com.pokebattle.pokebattleapi.service.BattleService;

@RestController
@RequestMapping("/battle")
public class BattleController {

    @Autowired
    private BattleService battleService;
    
    @GetMapping("/{username}/{opponent}")
    public ResponseEntity<BattleResultDto> startBattle(@PathVariable String username, @PathVariable String opponent) {
        BattleResultDto battleResultDto = battleService.doPokemonBattle(username, opponent);

        return ResponseEntity.ok(battleResultDto);
    }

}
