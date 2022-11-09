package com.pokebattle.pokebattleapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    public Team(Pokemon slotOne, Pokemon slotTwo, Pokemon slotThree) {
        this.slotOne = slotOne;
        this.slotTwo = slotTwo;
        this.slotThree = slotThree;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @ManyToOne
    @NotNull
    private Pokemon slotOne;
    
    @ManyToOne
    @NotNull
    private Pokemon slotTwo;
    
    @ManyToOne
    @NotNull
    private Pokemon slotThree;

}
