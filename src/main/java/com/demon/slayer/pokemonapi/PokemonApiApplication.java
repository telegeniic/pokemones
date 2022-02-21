package com.demon.slayer.pokemonapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"com.demon.slayer.pokemonapi.controllers", "com.demon.slayer.pokemonapi.services"})
@EntityScan("com.demon.slayer.pokemonapi.models")
@SpringBootApplication
public class PokemonApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonApiApplication.class, args);
	}

}
