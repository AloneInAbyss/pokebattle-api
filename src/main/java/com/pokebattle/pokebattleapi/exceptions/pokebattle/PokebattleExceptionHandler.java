package com.pokebattle.pokebattleapi.exceptions.pokebattle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PokebattleExceptionHandler {

    @ExceptionHandler(PokebattleException.class)
    public ResponseEntity<PokebattleExceptionDto> handle(PokebattleException exception) {
        String message = exception.getMessage();
        Integer code = exception.getCode();

        PokebattleExceptionDto dto = new PokebattleExceptionDto(message, code);

        return ResponseEntity.status(exception.getHttpStatus()).body(dto);
    }

}
