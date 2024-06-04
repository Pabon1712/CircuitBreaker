package com.animal.info.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.animal.info.entity.Animal;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
@RequestMapping("/info")
public class AnimalController {
	
	@Autowired
	@Lazy
    private RestTemplate restTemplate;

    public static final String SERVICE_ANIMALS="userService";

    private static final String URL = "http://localhost:9191/animals";
    
    @GetMapping("/animals")
    @CircuitBreaker(name =SERVICE_ANIMALS,fallbackMethod = "animalsList")
    public List<Animal> displayOrders(@RequestParam("specie") String specie) {
          String url = specie == "" ? URL : URL + "/" + specie;
          return restTemplate.getForObject(url, ArrayList.class);
      }
    

    public List<Animal> animalsList(Exception e){
        return Stream.of(
                new Animal(1,"Gato", "Felino", "Femenino"),
                new Animal(2,"Perro", "Canis familiaris", "Masculino"),
                new Animal(3,"Pescado", "vertebrados acuáticos,", "Femenino"),
                new Animal(4,"Oso Polar", "Mamíferos omnívoros", "Masculino"),
                new Animal(5,"Tigre", "Panthera", "Femenino"),
                new Animal(6,"Loro", "Psittacidae", "Masculino")
        ).collect(Collectors.toList());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
