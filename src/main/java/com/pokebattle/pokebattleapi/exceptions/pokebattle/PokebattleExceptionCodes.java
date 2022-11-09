package com.pokebattle.pokebattleapi.exceptions.pokebattle;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum PokebattleExceptionCodes {
    USER_NOT_FOUND(101, "User not found", HttpStatus.NOT_FOUND),
    USER_ALREADY_EXISTS(102, "Username already registered", HttpStatus.CONFLICT),
    INVALID_POKEMON_IDENTIFIER(201, "Invalid pokémon name/id", HttpStatus.NOT_FOUND),
    REACHED_MAX_POKEMONS(202, "Reached max pokémons limit, awesome!", HttpStatus.ACCEPTED),
    UNAVAIBLE_FOR_PULL(203, "You can only get one pokémon once every 2 minutes", HttpStatus.CONFLICT);

    private Integer code;
    private String message;
    private HttpStatus httpStatus;

    PokebattleExceptionCodes(Integer code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
