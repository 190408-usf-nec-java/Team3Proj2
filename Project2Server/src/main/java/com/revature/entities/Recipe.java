package com.revature.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
	@Table(name = "recipes")
public class Recipe {
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "recipe_id")
		private int id;
		@Column(nullable = false)
		private String name;
		@Column(nullable = false)
		private String directions;
	

		@ManyToMany
		@JoinTable(name = "restaurants_recipes", joinColumns = { @JoinColumn(name = "recipe_id") }, inverseJoinColumns = {
				@JoinColumn(name = "restaurant_id") })
		private List<Restaurant> restaurants;

		@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id", nullable=false)
		private User user;


		@OneToMany(
		        mappedBy = "recipe",
		        cascade = CascadeType.ALL,
		        orphanRemoval = true
		        )
		private List<Comment> comments;
		
		@ManyToMany
		@JoinTable(name = "recipe_tags", joinColumns = { @JoinColumn(name ="recipe_id")}, inverseJoinColumns = {
				@JoinColumn(name = "tag_id") })
		private List<Tag> tags;

		@ManyToMany
		@JoinTable(name = "recipes_utensils", joinColumns = { @JoinColumn(name = "recipe_id") }, inverseJoinColumns = {
				@JoinColumn(name = "utensil_id") })
		private List<Utensil> utensils;
		
		@OneToMany(
	        mappedBy = "recipe_id",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	        )
		private List<Contain> contains = new ArrayList<>();

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

		public String getDirections() {
			return directions;
		}

		public void setDirections(String directions) {
			this.directions = directions;
		}

		public List<Restaurant> getRestaurants() {
			return restaurants;
		}

		public void setRestaurants(List<Restaurant> restaurants) {
			this.restaurants = restaurants;
		}

		

		public User getUser() {
			return user;
		}

		public void setUser(User author) {
			this.user = author;
		}

		public List<Comment> getComments() {
			return comments;
		}

		public void setComments(List<Comment> comments) {
			this.comments = comments;
		}

		public List<Tag> getTags() {
			return tags;
		}

		public void setTags(List<Tag> tags) {
			this.tags = tags;
		}

		public List<Utensil> getUtensils() {
			return utensils;
		}

		public void setUtensils(List<Utensil> utensils) {
			this.utensils = utensils;
		}

		public List<Contain> getContains() {
			return contains;
		}

		public void setContains(List<Contain> contains) {
			this.contains = contains;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((user == null) ? 0 : user.hashCode());
			result = prime * result + ((comments == null) ? 0 : comments.hashCode());
			result = prime * result + ((contains == null) ? 0 : contains.hashCode());
			result = prime * result + ((directions == null) ? 0 : directions.hashCode());
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((restaurants == null) ? 0 : restaurants.hashCode());
			result = prime * result + ((tags == null) ? 0 : tags.hashCode());
			result = prime * result + ((utensils == null) ? 0 : utensils.hashCode());
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
			Recipe other = (Recipe) obj;
			if (user == null) {
				if (other.user != null)
					return false;
			} else if (!user.equals(other.user))
				return false;
			if (comments == null) {
				if (other.comments != null)
					return false;
			} else if (!comments.equals(other.comments))
				return false;
			if (contains == null) {
				if (other.contains != null)
					return false;
			} else if (!contains.equals(other.contains))
				return false;
			if (directions == null) {
				if (other.directions != null)
					return false;
			} else if (!directions.equals(other.directions))
				return false;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (restaurants == null) {
				if (other.restaurants != null)
					return false;
			} else if (!restaurants.equals(other.restaurants))
				return false;
			if (tags == null) {
				if (other.tags != null)
					return false;
			} else if (!tags.equals(other.tags))
				return false;
			if (utensils == null) {
				if (other.utensils != null)
					return false;
			} else if (!utensils.equals(other.utensils))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Recipe [id=" + id + ", name=" + name + ", directions=" + directions + ", restaurants=" + restaurants
					+ ", author=" + user + ", comments=" + comments + ", tags=" + tags + ", utensils=" + utensils
					+ ", contains=" + contains + "]";
		}

		

		public Recipe() {
			super();
			// TODO Auto-generated constructor stub
		}

		
		
	

}
