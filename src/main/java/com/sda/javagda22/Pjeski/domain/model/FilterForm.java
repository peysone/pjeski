package com.sda.javagda22.Pjeski.domain.model;


import com.sda.javagda22.Pjeski.domain.model.animal.AnimalType;
import lombok.Data;

@Data
public class FilterForm {
	//do szukania po mieście
	private String city;

	private Integer estimatedAge;

	private Integer weight;

	private AnimalType animalType;
}
