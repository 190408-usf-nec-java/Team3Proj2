package com.revature.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContainCk implements Serializable{

	
	@Column(name = "recipe")
	private int recipeId;
	
	@Column(name = "ingredient")
	private int ingredientId;

	public ContainCk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContainCk(int recipeId, int ingredientId) {
		super();
		this.recipeId = recipeId;
		this.ingredientId = ingredientId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingredientId;
		result = prime * result + recipeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContainCk other = (ContainCk) obj;
		if (ingredientId != other.ingredientId)
			return false;
		if (recipeId != other.recipeId)
			return false;
		return true;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	
	
	
	
}
