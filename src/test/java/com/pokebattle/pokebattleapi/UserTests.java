package com.pokebattle.pokebattleapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.pokebattle.pokebattleapi.model.User;
import com.pokebattle.pokebattleapi.repository.UserRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class UserTests {

    @Autowired
    private MockMvc mvc;

    @BeforeAll
    public static void createUser(@Autowired UserRepository userRepository) {
        User user = new User("aloneinabyss", new ArrayList<>());

        userRepository.save(user);
    }

    @Test
    public void shouldCreateNewUser() throws Exception {
        String username = "devilady";

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
    
    @Test
    public void shouldSearchForAUser() throws Exception {
        String username = "aloneinabyss";

        mvc.perform(get("/users/" + username)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                    .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.username").value(username))
                    .andExpect(jsonPath("$.pokemons").isArray());
    }
}
