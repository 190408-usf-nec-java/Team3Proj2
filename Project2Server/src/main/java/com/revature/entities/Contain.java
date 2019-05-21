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
	    @MapsId("rId")
	    private Recipe recipe;
	

	    @ManyToOne(fetch = FetchType.LAZY)
	    @MapsId("iId")
	    private Ingredient ingredient;
	    
	    private String amount;
	    private String unit;
		public Contain() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Contain(ContainCk id, Recipe recipe, Ingredient ingredient, String amount, String unit) {
			super();
			this.id = id;
			this.recipe = recipe;
			this.ingredient = ingredient;
			this.amount = amount;
			this.unit = unit;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((amount == null) ? 0 : amount.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
			result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
			result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
			if (ingredient == null) {
				if (other.ingredient != null)
					return false;
			} else if (!ingredient.equals(other.ingredient))
				return false;
			if (recipe == null) {
				if (other.recipe != null)
					return false;
			} else if (!recipe.equals(other.recipe))
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
			return "Contain [id=" + id + ", recipe=" + recipe + ", ingredient=" + ingredient + ", amount=" + amount
					+ ", unit=" + unit + "]";
		}
	
	     
	

}
