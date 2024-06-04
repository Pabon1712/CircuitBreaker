package com.animal.info.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "animals")
public class Animal {

	 @Id
	 @GeneratedValue
	 private int id;
	 private String name;
	 private String species;
	 private String sex;
	 
	 
	 public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Animal(String name, String species, String sex) {
	    this.name = name;
	    this.species = species;
	    this.sex = sex;
	 }
    
    public Animal(int id,String name, String species, String sex) {
    	this.id = id;
	    this.name = name;
	    this.species = species;
	    this.sex = sex;
	 }
    
    public Animal() {
    	
    }
}
