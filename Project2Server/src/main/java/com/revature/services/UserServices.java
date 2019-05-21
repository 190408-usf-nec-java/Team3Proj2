package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.User;
import com.revature.repositories.UserRepository;

@Service
public class UserServices {
	@Autowired
	UserRepository userRepository;

	/*@Inject
	public UserServices(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}*/

	public User getById(int id) {
		return this.userRepository.getById(id);
	}

	public User create(User user) {
		return this.userRepository.create(user);
	}

	public User update(User user) {
		return this.userRepository.update(user);
	}

	public User deleteById(int id) {
		return this.userRepository.deleteById(id);
	}

}
