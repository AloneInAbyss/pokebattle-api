package com.pokebattle.pokebattleapi.dto;

import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.Team;

import lombok.Getter;

@Getter
public class TeamDto {

    public TeamDto(Team team) {
        this.slotOne = team.getSlotOne();
        this.slotTwo = team.getSlotTwo();
        this.slotThree = team.getSlotThree();
    }

    private Pokemon slotOne;
    private Pokemon slotTwo;
    private Pokemon slotThree;

}
