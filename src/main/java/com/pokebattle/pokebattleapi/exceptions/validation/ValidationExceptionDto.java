package com.pokebattle.pokebattleapi.exceptions.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValidationExceptionDto {

    private String field;
    private String message;
    
}
