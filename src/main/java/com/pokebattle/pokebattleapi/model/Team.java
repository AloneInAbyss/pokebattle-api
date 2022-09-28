package com.pokebattle.pokebattleapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team {

    public Team(Long slotOneId, Long slotTwoId, Long slotThreeId) {
        this.slotOneId = slotOneId;
        this.slotTwoId = slotTwoId;
        this.slotThreeId = slotThreeId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotNull
    private Long slotOneId;
    
    @NotNull
    private Long slotTwoId;
    
    @NotNull
    private Long slotThreeId;

}
