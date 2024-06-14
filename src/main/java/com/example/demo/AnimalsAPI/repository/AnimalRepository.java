package com.example.demo.AnimalsAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.AnimalsAPI.data.Animal;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AnimalRepository {

	public Animal[] getAllAnimals() throws IOException {
		String url = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		String json = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, Animal[].class);
	}

	public Animal getAnimalById(int id) throws IOException {
		String url = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI?id=" + id;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		String json = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		Animal[] animals = mapper.readValue(json, Animal[].class);
		return animals.length > 0 ? animals[0] : null;
	}
}