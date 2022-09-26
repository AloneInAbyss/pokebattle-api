package com.pokebattle.pokebattleapi.model;

import java.util.HashMap;

import com.pokebattle.pokebattleapi.model.enums.StatTypes;

public class Pokemon {

    public Pokemon(String name, Long id, HashMap<StatTypes, Integer> stats) {
        this.name = name;
        this.id = id;
        this.stats = stats;
    }

    private String name;

    private Long id;

    private HashMap<StatTypes, Integer> stats;

}
