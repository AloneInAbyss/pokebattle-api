package com.pokebattle.pokebattleapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PokebattleApiApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldCreateNewUser() throws Exception {
        String username = "aloneinabyss";

        mvc.perform(post("/users/register")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{ \"username\": \"" + username + "\" }")
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(redirectedUrlPattern("http://*/users/" + username))
                .andExpect(content()
                    .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.username").value(username))
                    .andExpect(jsonPath("$.pokemons").isArray());
        
    }

}
