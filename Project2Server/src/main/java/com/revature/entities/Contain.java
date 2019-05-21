package com.revature.entities;

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
	    @MapsId("recipesId")
	    private Recipe recipes;
	

	    @ManyToOne(fetch = FetchType.LAZY)
	    @MapsId("ingredientsId")
	    private Ingredient ingredients;
	    
	    private String amount;
	    private String unit;
		public Contain() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Contain(Recipe recipe, Ingredient ingredient, String amount, String unit) {
			super();
			this.id = id;
			this.recipes = recipe;
			this.ingredients = ingredient;
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
			result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
			result = prime * result + ((recipes == null) ? 0 : recipes.hashCode());
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
			return recipes;
		}
		public void setRecipe(Recipe recipe) {
			this.recipes = recipe;
		}
		public Ingredient getIngredient() {
			return ingredients;
		}
		public void setIngredient(Ingredient ingredient) {
			this.ingredients = ingredient;
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
			if (ingredients == null) {
				if (other.ingredients != null)
					return false;
			} else if (!ingredients.equals(other.ingredients))
				return false;
			if (recipes == null) {
				if (other.recipes != null)
					return false;
			} else if (!recipes.equals(other.recipes))
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
			return "Contain [id=" + id + ", recipe=" + recipes + ", ingredient=" + ingredients + ", amount=" + amount
					+ ", unit=" + unit + "]";
		}
	
	     
	

}
