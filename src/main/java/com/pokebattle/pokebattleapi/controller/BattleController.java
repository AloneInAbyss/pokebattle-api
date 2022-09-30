package com.pokebattle.pokebattleapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokebattle.pokebattleapi.dto.BattleResultDto;
import com.pokebattle.pokebattleapi.service.BattleService;
import com.pokebattle.pokebattleapi.service.battle.BattleResult;

@RestController
@RequestMapping("/battle")
public class BattleController {

    @Autowired
    private BattleService battleService;

    @GetMapping("/{player1}/{player2}")
    public ResponseEntity<BattleResultDto> startBattle(@PathVariable(name = "player1") String playerOneUsername,
            @PathVariable(name = "player2") String playerTwoUsername) {
        BattleResult battleResult = battleService.startBattle(playerOneUsername, playerTwoUsername);

        BattleResultDto battleResultDto = new BattleResultDto(battleResult);

        return ResponseEntity.ok(battleResultDto);
    }

}
