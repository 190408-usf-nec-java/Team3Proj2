package com.revature.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.revature.entities.Ingredient;
import com.revature.repositories.IngredientRepository;
@Service
public class IngredientServices {

	IngredientRepository ingredientRepository;

	@Inject
	public IngredientServices(IngredientRepository ingredientRepository) {
		super();
		this.ingredientRepository = ingredientRepository;
	}

	public Ingredient getById(int id) {
		return this.ingredientRepository.getById(id);
	}

	public Ingredient create(Ingredient ingredient) {
		return this.ingredientRepository.create(ingredient);
	}

	public Ingredient update(Ingredient ingredient) {
		return this.ingredientRepository.update(ingredient);
	}

	public Ingredient deleteById(int id) {
		return this.ingredientRepository.deleteById(id);
	}


	
}
