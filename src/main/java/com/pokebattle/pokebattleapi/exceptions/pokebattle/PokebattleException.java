package com.pokebattle.pokebattleapi.exceptions.pokebattle;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class PokebattleException extends RuntimeException {

    public PokebattleException(PokebattleExceptionCodes pokebattleExceptionCodes) {
        this.code = pokebattleExceptionCodes.getCode();
        this.message = pokebattleExceptionCodes.getMessage();
        this.httpStatus = pokebattleExceptionCodes.getHttpStatus();
    }
    
    private Integer code;
    private String message;
    private HttpStatus httpStatus;

}
