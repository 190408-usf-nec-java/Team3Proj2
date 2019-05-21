package com.revature.services;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
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
	private String hash(String password,String salt)
	{
		String sha256hex = Hashing.sha256()
				  .hashString(password+salt, StandardCharsets.UTF_8)
				  .toString();
		return sha256hex;
	}

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

	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		User toCheck = this.userRepository.getByUsername(username);
		return toCheck.getHashedpass().equals(hash(password,toCheck.getSalt()));
	}

}
