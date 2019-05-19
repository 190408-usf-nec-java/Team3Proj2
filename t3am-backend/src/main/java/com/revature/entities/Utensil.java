package com.revature.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utensils")
public class Utensil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;

	@ManyToMany
	@JoinTable(name = "recipes_utensils", joinColumns = { @JoinColumn(name = "utensil_id") }, inverseJoinColumns = {
			@JoinColumn(name = "recipe_id") })
	private List<Recipe> recipes;

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

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((recipes == null) ? 0 : recipes.hashCode());
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
		Utensil other = (Utensil) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recipes == null) {
			if (other.recipes != null)
				return false;
		} else if (!recipes.equals(other.recipes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Utensil [id=" + id + ", name=" + name + ", recipes=" + recipes + "]";
	}

	public Utensil(int id, String name, List<Recipe> recipes) {
		super();
		this.id = id;
		this.name = name;
		this.recipes = recipes;
	}

	public Utensil() {
		super();
		// TODO Auto-generated constructor stub
	}

}
