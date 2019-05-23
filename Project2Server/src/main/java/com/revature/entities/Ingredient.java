package com.revature.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingredients")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;


	@OneToMany (
			mappedBy= "ingredients",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Contain> contains;
	
	@ManyToMany
	@JoinTable(name = "ingredient_tags", joinColumns = { @JoinColumn(name ="ingredient_id")}, inverseJoinColumns = {
			@JoinColumn(name = "tag_id") })
	private List<Tag> tags;

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

	public List<Contain> getContains() {
		return contains;
	}

	public void setContains(List<Contain> contains) {
		this.contains = contains;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contains == null) ? 0 : contains.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		Ingredient other = (Ingredient) obj;
		if (contains == null) {
			if (other.contains != null)
				return false;
		} else if (!contains.equals(other.contains))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", contains=" + contains + ", tags=" + tags + "]";
	}

	public Ingredient(int id, String name, List<Contain> contains, List<Tag> tags) {
		super();
		this.id = id;
		this.name = name;
		this.contains = contains;
		this.tags = tags;
	}

	public Ingredient() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	

	
}
