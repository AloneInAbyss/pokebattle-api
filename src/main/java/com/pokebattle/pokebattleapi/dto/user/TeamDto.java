package com.pokebattle.pokebattleapi.dto.user;

import java.util.HashMap;

import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.enums.TeamSlots;

import lombok.Getter;

@Getter
public class TeamDto {
    
    public TeamDto(HashMap<TeamSlots, Pokemon> team) {
        this.team.put(TeamSlots.ONE, new PokemonDto(team.get(TeamSlots.ONE)));
        this.team.put(TeamSlots.TWO, new PokemonDto(team.get(TeamSlots.TWO)));
        this.team.put(TeamSlots.THREE, new PokemonDto(team.get(TeamSlots.THREE)));
    }

    private HashMap<TeamSlots, PokemonDto> team;

}
