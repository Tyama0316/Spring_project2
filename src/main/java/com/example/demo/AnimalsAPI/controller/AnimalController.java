package com.example.demo.AnimalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.AnimalsAPI.data.Animal;
import com.example.demo.AnimalsAPI.service.AnimalService;

@Controller
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animalsapi")
    public String searchAnimals(Model model) throws IOException {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);
        return "search.html";
    }

    @GetMapping("/animalsapi/detail")
    public String detailAnimal(@RequestParam("id") int id, Model model) throws IOException {
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);
        return "detail.html";
    }
}