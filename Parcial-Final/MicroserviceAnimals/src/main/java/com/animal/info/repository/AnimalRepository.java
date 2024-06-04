package com.animal.info.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.animal.info.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal,Integer> {

    List<Animal> findBySpecies(String species);

}
