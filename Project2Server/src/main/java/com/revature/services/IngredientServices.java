package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Ingredient;
import com.revature.repositories.IngredientRepository;
@Service
public class IngredientServices {

	@Autowired
	IngredientRepository ingredientRepository;

	/*@Inject
	public IngredientServices(IngredientRepository ingredientRepository) {
		super();
		this.ingredientRepository = ingredientRepository;
	}*/

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

	public List<Ingredient> getByName(String item) {
		return this.ingredientRepository.getByName(item);
	}

	public Ingredient getIdbyName(String string) {
		return this.ingredientRepository.getByExactName(string);
	}


	
}
