package com.pokebattle.pokebattleapi.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokebattle.pokebattleapi.model.Attributes;
import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.repository.PokemonRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PokemonLoader implements InitializingBean {

    @Autowired
    private ResourceLoader resourceLoader;

    private PokemonRepository pokemonRepository;

    public PokemonLoader(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;

        log.info("Registering pokémons into database...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadPokemons();

        log.info("Finished registering pokémons into database!");
    }

    public void loadPokemons() throws IOException {
        final int QUANTITY = 151;

        for (int i = 1; i <= QUANTITY; i++) {
            Resource resourceFile = resourceLoader.getResource("classpath:data/pokemon-" + i + ".json");

            Pokemon pokemon = readPokemonFile(resourceFile);

            pokemonRepository.save(pokemon);
        }
    }

    private Pokemon readPokemonFile(Resource resourceFile) throws IOException {
        InputStream inputStream = resourceFile.getInputStream();

        String jsonData = readFromInputStream(inputStream);

        return parseJsonPokemonData(jsonData);
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }

        return resultStringBuilder.toString();
    }

    private Pokemon parseJsonPokemonData(String jsonData) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode pokemonData = mapper.readTree(jsonData);

        String pokemonName = pokemonData.get("name").asText();

        HashMap<String, Integer> pokemonAttributes = parsePokemonAttributes(pokemonData);

        return new Pokemon(
            pokemonName,
            new Attributes(
                pokemonAttributes.get("hp"),
                pokemonAttributes.get("attack"),
                pokemonAttributes.get("defense")));

    }

    private HashMap<String, Integer> parsePokemonAttributes(JsonNode pokemonData) {
        HashMap<String, Integer> stats = new HashMap<>();
        List<String> validStatsNames = List.of("hp", "attack", "defense");

        JsonNode statsArray = pokemonData.get("stats");
        for (final JsonNode statsNode : statsArray) {
            String statName = statsNode.get("stat").get("name").asText();
            Integer statValue = statsNode.get("base_stat").asInt();

            Stream<String> filter = validStatsNames.stream().filter(name -> name.equals(statName));
            if (filter.count() == 1) {
                stats.put(statName, statValue);
            }
        }

        return stats;
    }

}
