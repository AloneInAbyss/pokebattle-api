package com.pokebattle.pokebattleapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokebattle.pokebattleapi.dto.BattleResultDto;
import com.pokebattle.pokebattleapi.exceptions.pokebattle.PokebattleExceptionDto;
import com.pokebattle.pokebattleapi.service.BattleService;
import com.pokebattle.pokebattleapi.service.battle.BattleResult;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Battle")
@RestController
@RequestMapping("/battle")
public class BattleController {

    @Autowired
    private BattleService battleService;

    @Operation(summary = "Battle against another user")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Battle completed successfully", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = BattleResultDto.class)) }),
        @ApiResponse(responseCode = "404", description = "User not found", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = PokebattleExceptionDto.class)) }),
        @ApiResponse(responseCode = "409", description = "User doesn't have a valid pokémon team", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = PokebattleExceptionDto.class)) }) })
    @GetMapping("/{player1}/{player2}")
    public ResponseEntity<BattleResultDto> startBattle(@PathVariable(name = "player1") String playerOneUsername,
            @PathVariable(name = "player2") String playerTwoUsername) {
        BattleResult battleResult = battleService.startBattle(playerOneUsername, playerTwoUsername);

        BattleResultDto battleResultDto = new BattleResultDto(battleResult);

        return ResponseEntity.ok(battleResultDto);
    }

}
