package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Restaurant;
import com.revature.repositories.RestaurantRepository;
@Service 
public class RestaurantServices {

	@Autowired
	RestaurantRepository restaurantRepository;
	
	/*@Inject
	public RestaurantServices(RestaurantRepository restaurantRepository) {
		super();
		this.restaurantRepository = restaurantRepository;
	}*/

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
