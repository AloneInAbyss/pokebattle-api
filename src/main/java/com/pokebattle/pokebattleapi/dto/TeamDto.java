package com.pokebattle.pokebattleapi.dto;

import com.pokebattle.pokebattleapi.model.Team;

import lombok.Getter;

@Getter
public class TeamDto {

    public TeamDto(Team team) {
        this.slotOne = team.getSlotOneId();
        this.slotTwo = team.getSlotTwoId();
        this.slotThree = team.getSlotThreeId();
    }

    private Long slotOne;
    private Long slotTwo;
    private Long slotThree;

}
