package com.pokebattle.pokebattleapi.service.battle;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BattleResult {
    
    private String winner;
    private List<Round> rounds;

}
