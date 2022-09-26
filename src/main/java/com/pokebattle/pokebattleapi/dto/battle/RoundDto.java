package com.pokebattle.pokebattleapi.dto.battle;

import com.pokebattle.pokebattleapi.dto.user.PokemonDto;
import com.pokebattle.pokebattleapi.model.enums.StatTypes;

public class RoundDto {

    private String winner;
    private StatTypes criteria;
    private PokemonDto player1;
    private PokemonDto player2;
    
}
