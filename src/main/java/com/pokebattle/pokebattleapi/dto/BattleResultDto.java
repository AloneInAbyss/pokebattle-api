package com.pokebattle.pokebattleapi.dto;

import java.util.ArrayList;
import java.util.List;

import com.pokebattle.pokebattleapi.service.battle.BattleResult;

import lombok.Getter;

@Getter
public class BattleResultDto {

    private String winner;
    private List<RoundDto> battle = new ArrayList<>();

    public BattleResultDto(BattleResult battleResult) {
        this.winner = battleResult.getWinner();

        battleResult.getRounds().forEach(round -> {
            this.battle.add(new RoundDto(round));
        });
    }
    
}
