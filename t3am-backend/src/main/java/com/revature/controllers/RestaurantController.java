package com.revature.controllers;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Restaurant;
import com.services.services.RestaurantServices;
@RestController // All methods infer @ResponseBody
@RequestMapping("restaurant")
public class RestaurantController {
private RestaurantServices restaurantService;
	
	@Inject
	public RestaurantController(RestaurantServices restaurantService) {
		super();
		this.restaurantService = restaurantService;
	}

	@GetMapping("/{id}")
	public Restaurant getById(@PathVariable int id) {
		return Optional.ofNullable(this.restaurantService.getById(id))
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
		return this.restaurantService.create(restaurant);
	}
	
	@PutMapping("")
	public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
		return this.restaurantService.update(restaurant);
	}
	
	@DeleteMapping("/{id}")
	public Restaurant deleteRestaurant(@PathVariable int id) {
		return this.restaurantService.deleteById(id);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}


}
