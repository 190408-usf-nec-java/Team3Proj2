package com.services.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.revature.entities.Recipe;
import com.revature.repositories.RecipeRepository;
@Service

public class RecipeServices {
	
	RecipeRepository recipeRepository;

	@Inject
	public RecipeServices(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	public Recipe getById(int id) {
		return this.recipeRepository.getById(id);
	}

	public Recipe create(Recipe recipe) {
		return this.recipeRepository.create(recipe);
	}

	public Recipe update(Recipe recipe) {
		return this.recipeRepository.update(recipe);
	}

	public Recipe deleteById(int id) {
		return this.recipeRepository.deleteById(id);
	}



}
