package com.revature.repositories;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Restaurant;
@Repository

public class RestaurantRepository {

	SessionFactory sf;

	@Inject
	public RestaurantRepository(SessionFactory sf) {
		this.sf = sf;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Restaurant getById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(Restaurant.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Restaurant create(Restaurant restaurant) {
		Session session = sf.getCurrentSession();
		session.save(restaurant);
		return restaurant;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Restaurant update(Restaurant restaurant) {
		Session session = sf.getCurrentSession();
		session.merge(restaurant);
		return restaurant;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Restaurant deleteById(int id) {
		Session session = sf.getCurrentSession();
		Restaurant restaurant = session.get(Restaurant.class, id);
		if (restaurant == null)
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(restaurant);
		return restaurant;

	}
	
}
