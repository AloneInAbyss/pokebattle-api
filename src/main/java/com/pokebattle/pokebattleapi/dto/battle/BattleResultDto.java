package com.pokebattle.pokebattleapi.dto.battle;

import java.util.List;

import lombok.Getter;

@Getter
public class BattleResultDto {
    
    public BattleResultDto(String winner, List<RoundDto> battleInfo) {
        this.winner = winner;
        this.battleInfo = battleInfo;
    }
    
    private String winner;
    private List<RoundDto> battleInfo;

}
