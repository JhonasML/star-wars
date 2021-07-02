package com.meli.starwarsnomes.service;

import com.meli.starwarsnomes.entity.StarWarsCharacter;
import com.meli.starwarsnomes.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<StarWarsCharacter> getCharacters(String name){
       return characterRepository.fetchCharacters(name);
    }
}
