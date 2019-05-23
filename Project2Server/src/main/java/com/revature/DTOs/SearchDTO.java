package com.revature.DTOs;

public class SearchDTO {

	private String item;
	private String recipe;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getRecipe() {
		return recipe;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
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
		SearchDTO other = (SearchDTO) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		return true;
	}
	public SearchDTO(String item, String recipe) {
		super();
		this.item = item;
		this.recipe = recipe;
	}
	public SearchDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
