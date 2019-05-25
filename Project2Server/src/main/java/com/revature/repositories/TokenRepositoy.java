package com.revature.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Token;
import com.revature.entities.User;
@Repository
public class TokenRepositoy {
	@Autowired
	SessionFactory sf;
	@Transactional(propagation = Propagation.REQUIRED)
	public Token newToken(User u) {
		Token t = new Token(u);
		Session session = sf.getCurrentSession();
		session.save(t);
		return t;
	}
}
