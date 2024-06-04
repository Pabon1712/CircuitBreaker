package com.animals.specie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.animals.specie.entity.Animals;

public interface AnimalsRepository extends JpaRepository<Animals,Integer> {

    List<Animals> findBySpecies(String species);


}
