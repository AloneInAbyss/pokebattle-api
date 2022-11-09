package com.pokebattle.pokebattleapi.exceptions.pokebattle;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PokebattleExceptionDto {

    private String message;
    private Integer code;

}
