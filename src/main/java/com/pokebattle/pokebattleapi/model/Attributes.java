package com.pokebattle.pokebattleapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "attributes")
public class Attributes {

    public Attributes(int hp, int attack, int defense) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotNull @Min(value = 0) @Max(value = 1000)
    private Integer hp;
    
    @NotNull @Min(value = 0) @Max(value = 1000)
    private Integer attack;
    
    @NotNull @Min(value = 0) @Max(value = 1000)
    private Integer defense;

}
