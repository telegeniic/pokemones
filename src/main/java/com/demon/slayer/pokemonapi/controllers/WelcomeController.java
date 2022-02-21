package com.demon.slayer.pokemonapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {
    
    @GetMapping("/hola")
    public String welcome(){
        return "Hola Mundo";
    }
}
