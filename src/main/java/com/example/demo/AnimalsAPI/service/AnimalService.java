package com.example.demo.AnimalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.AnimalsAPI.data.Animal;
import com.example.demo.AnimalsAPI.repository.AnimalRepository;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals() throws IOException {
        return Arrays.asList(animalRepository.getAllAnimals());
    }

    public Animal getAnimalById(int id) throws IOException {
        return animalRepository.getAnimalById(id);
    }
}