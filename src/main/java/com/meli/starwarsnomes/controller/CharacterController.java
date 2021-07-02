package com.meli.starwarsnomes.controller;

import com.meli.starwarsnomes.entity.StarWarsCharacter;
import com.meli.starwarsnomes.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<StarWarsCharacter> getCharacters(@RequestParam(defaultValue = "") String name){
        return characterService.getCharacters(name);
    }
}
