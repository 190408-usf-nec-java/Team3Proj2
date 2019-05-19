package com.services.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.revature.entities.Restaurant;
import com.revature.repositories.RestaurantRepository;
@Service

public class RestaurantServices {
	RestaurantRepository restaurantRepository;

	@Inject
	public RestaurantServices(RestaurantRepository restaurantRepository) {
		super();
		this.restaurantRepository = restaurantRepository;
	}

	public Restaurant getById(int id) {
		return this.restaurantRepository.getById(id);
	}

	public Restaurant create(Restaurant restaurant) {
		return this.restaurantRepository.create(restaurant);
	}

	public Restaurant update(Restaurant restaurant) {
		return this.restaurantRepository.update(restaurant);
	}

	public Restaurant deleteById(int id) {
		return this.restaurantRepository.deleteById(id);
	}



}
