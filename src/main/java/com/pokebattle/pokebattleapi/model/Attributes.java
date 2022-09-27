package com.pokebattle.pokebattleapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Entity
@Table(name = "attributes")
public class Attributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @Min(value = 0) @Max(value = 1000)
    private Integer hp;
    
    @NotNull @Min(value = 0) @Max(value = 1000)
    private Integer attack;
    
    @NotNull @Min(value = 0) @Max(value = 1000)
    private Integer defense;

}
