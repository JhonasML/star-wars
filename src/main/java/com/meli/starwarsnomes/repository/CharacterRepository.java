package com.meli.starwarsnomes.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.starwarsnomes.entity.StarWarsCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Repository
public class CharacterRepository {
    private final String FILE_PATH = "src/main/resources/starwars.json";
    private final File file = new File(FILE_PATH);

    private final ObjectMapper mapper;

    @Autowired
    public CharacterRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<StarWarsCharacter> fetchCharacters(String name) {
        return fetchAllCharacters().stream().filter(c -> isNull(name) || c.getName().contains(name)).collect(Collectors.toList());
    }

    private List<StarWarsCharacter> fetchAllCharacters() {
        List<StarWarsCharacter> foods = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(file);
            TypeReference<List<StarWarsCharacter>> typeReference = new TypeReference<>() {
            };

            foods = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return foods;
    }
}
