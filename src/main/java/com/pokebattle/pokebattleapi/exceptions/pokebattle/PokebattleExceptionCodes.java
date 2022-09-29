package com.pokebattle.pokebattleapi.exceptions.pokebattle;

import lombok.Getter;

@Getter
public enum PokebattleExceptionCodes {
    USER_NOT_FOUND(101, "User not found"),
    USER_ALREADY_EXISTS(102, "Username already registered"),
    INVALID_POKEMON_IDENTIFIER(201, "Invalid pokémon name/id");

    private Integer code;
    private String message;

    PokebattleExceptionCodes(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
