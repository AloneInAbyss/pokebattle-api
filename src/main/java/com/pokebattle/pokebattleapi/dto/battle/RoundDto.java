package com.pokebattle.pokebattleapi.dto.battle;

import com.pokebattle.pokebattleapi.dto.user.PokemonDto;
import com.pokebattle.pokebattleapi.model.enums.StatTypes;

import lombok.Getter;

@Getter
public class RoundDto {

    public RoundDto(String winner, StatTypes criteria, PokemonDto player1, PokemonDto player2) {
        this.winner = winner;
        this.criteria = criteria;
        this.player1 = player1;
        this.player2 = player2;
    }
    
    private String winner;
    private StatTypes criteria;
    private PokemonDto player1;
    private PokemonDto player2;
    
}
