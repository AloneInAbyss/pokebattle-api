package com.pokebattle.pokebattleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokebattleApiApplication {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.default", "dev");
		SpringApplication.run(PokebattleApiApplication.class, args);
	}

}
