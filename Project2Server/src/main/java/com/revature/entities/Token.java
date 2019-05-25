package com.revature.entities;

import java.sql.Timestamp;
import java.util.List;

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
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "tokens")
public class Token {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "token_id")
	private int id;

	@Column(nullable = false)
	private Timestamp expiration;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getExpiration() {
		return expiration;
	}

	public void setExpiration(Timestamp expiration) {
		this.expiration = expiration;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiration == null) ? 0 : expiration.hashCode());
		result = prime * result + id;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Token other = (Token) obj;
		if (expiration == null) {
			if (other.expiration != null)
				return false;
		} else if (!expiration.equals(other.expiration))
			return false;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Token [id=" + id + ", expiration=" + expiration + ", user=" + user + "]";
	}

	public Token(User u) {
		super();
		this.user = u;
		this.expiration = new Timestamp(System.currentTimeMillis() + 10800000);
	}

	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
