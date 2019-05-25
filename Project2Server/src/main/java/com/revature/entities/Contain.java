package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="contains")
public class Contain {
	
	@EmbeddedId
	private ContainCk id;
	
	 	@ManyToOne(fetch = FetchType.LAZY)
	    @MapsId("recipeId")
	    private Recipe recipe_id;
	

	    @ManyToOne(fetch = FetchType.LAZY)
	    @MapsId("ingredientId")
	    private Ingredient ingredient_id;
	    
	    private String amount;
	    private String unit;
		public Contain() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Contain(Recipe recipe, Ingredient ingredient, String amount, String unit) {
			super();
			this.id = id;
			this.recipe_id = recipe;
			this.ingredient_id = ingredient;
			this.amount = amount;
			this.unit = unit;
			id = new ContainCk(recipe.getId(), ingredient.getId());
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((amount == null) ? 0 : amount.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((ingredient_id == null) ? 0 : ingredient_id.hashCode());
			result = prime * result + ((recipe_id == null) ? 0 : recipe_id.hashCode());
			result = prime * result + ((unit == null) ? 0 : unit.hashCode());
			return result;
		}
		
		
		public ContainCk getId() {
			return id;
		}
		public void setId(ContainCk id) {
			this.id = id;
		}
		public Recipe getRecipe() {
			return recipe_id;
		}
		public void setRecipe(Recipe recipe) {
			this.recipe_id = recipe;
		}
		
		public Recipe getRecipe_id() {
			return recipe_id;
		}
		public void setRecipe_id(Recipe recipe_id) {
			this.recipe_id = recipe_id;
		}
		public Ingredient getIngredient_id() {
			return ingredient_id;
		}
		public void setIngredient_id(Ingredient ingredient_id) {
			this.ingredient_id = ingredient_id;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getUnit() {
			return unit;
		}
		public void setUnit(String unit) {
			this.unit = unit;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Contain other = (Contain) obj;
			if (amount == null) {
				if (other.amount != null)
					return false;
			} else if (!amount.equals(other.amount))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (ingredient_id == null) {
				if (other.ingredient_id != null)
					return false;
			} else if (!ingredient_id.equals(other.ingredient_id))
				return false;
			if (recipe_id == null) {
				if (other.recipe_id != null)
					return false;
			} else if (!recipe_id.equals(other.recipe_id))
				return false;
			if (unit == null) {
				if (other.unit != null)
					return false;
			} else if (!unit.equals(other.unit))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "" + amount + " " + unit + " " + ingredient_id.getName();
		}
	
	     
	

}
