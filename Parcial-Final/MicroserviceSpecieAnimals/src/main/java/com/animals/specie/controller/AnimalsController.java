package com.animals.specie.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.animals.specie.entity.Animals;
import com.animals.specie.repository.AnimalsRepository;

@RestController
@RequestMapping("/animals")
public class AnimalsController {

	@Autowired
    private AnimalsRepository animalsRepisority;
	
	@GetMapping
	public List<Animals> getOrders(){
		return animalsRepisority.findAll();
	}
	@GetMapping("/{species}")
	public List<Animals> getOrdersBySpecies(@PathVariable String species){
		return animalsRepisority.findBySpecies(species);
	}
	
}
