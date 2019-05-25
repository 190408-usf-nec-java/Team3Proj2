package com.revature.services;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.revature.DTOs.UserDTO;
import com.revature.entities.Token;
import com.revature.entities.User;
import com.revature.repositories.TokenRepositoy;
import com.revature.repositories.UserRepository;

@Service
public class UserServices {
	@Autowired
	UserRepository userRepository;
	@Autowired
	TokenRepositoy tokenRepository;

	/*@Inject
	public UserServices(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}*/
	private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
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

	public Token login(String username, String password) {
		// TODO Auto-generated method stub
		User toCheck = this.userRepository.getByUsername(username);
		if(toCheck.getHashedpass().equals(hash(password,toCheck.getSalt())))
		{
			return this.tokenRepository.newToken(toCheck);
		}
		
		return null;
	}

	public void signUp(UserDTO user) {
		String salt = getSaltString();
		User toAdd = new User(user.getFname(), user.getLname(), user.getUsername(), hash(user.getPassword(),salt), salt, user.getEmail());
		this.userRepository.create(toAdd);
		
	}

}
