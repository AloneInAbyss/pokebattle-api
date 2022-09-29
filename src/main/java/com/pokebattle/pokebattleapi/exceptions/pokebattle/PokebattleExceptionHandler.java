package com.pokebattle.pokebattleapi.exceptions.pokebattle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PokebattleExceptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PokebattleException.class)
    public PokebattleExceptionDto handle(PokebattleException exception) {
        String message = exception.getMessage();
        Integer code = exception.getCode();

        PokebattleExceptionDto dto = new PokebattleExceptionDto(message, code);

        return dto;
    }

}
