package com.pokebattle.pokebattleapi.exceptions.pokebattle;

import lombok.Getter;

@Getter
public class PokebattleException extends RuntimeException {

    public PokebattleException(PokebattleExceptionCodes pokebattleExceptionCodes) {
        this.code = pokebattleExceptionCodes.getCode();
        this.message = pokebattleExceptionCodes.getMessage();
    }
    
    private Integer code;
    private String message;

}
