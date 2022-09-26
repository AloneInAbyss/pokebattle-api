package com.pokebattle.pokebattleapi.dto.user;

import lombok.Getter;

@Getter
public class UserCreationDto {

    public UserCreationDto(String username, String privateToken) {
        this.username = username;
        this.privateToken = privateToken;
    }

    private String username;
    private String privateToken;
    
}
