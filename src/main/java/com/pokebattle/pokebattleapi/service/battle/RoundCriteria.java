package com.pokebattle.pokebattleapi.service.battle;

import java.util.List;
import java.util.Random;

public enum RoundCriteria {
    HP, ATTACK, DEFENSE;

    private static final List<RoundCriteria> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static RoundCriteria random() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
