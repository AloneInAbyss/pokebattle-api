package com.pokebattle.pokebattleapi.dto;

import com.pokebattle.pokebattleapi.service.battle.Round;

import lombok.Getter;

@Getter
public class RoundDto {

    private String winner;
    private String criteria;
    private PokemonDto playerOne;
    private PokemonDto playerTwo;
    
    public RoundDto(Round round) {
        this.winner = round.getWinner();
        this.criteria = round.getCriteria().name();
        this.playerOne = new PokemonDto(round.getUsersPokemons().get("playerOne"));
        this.playerTwo = new PokemonDto(round.getUsersPokemons().get("playerTwo"));
    }

}
