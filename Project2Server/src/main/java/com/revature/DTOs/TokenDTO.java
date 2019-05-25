package com.revature.DTOs;

import java.sql.Timestamp;

public class TokenDTO 
{
	private int tokenID;
	private int userID;
	private String username;
	public TokenDTO(int tokenID, int userID, String username, Timestamp expiry) {
		super();
		this.tokenID = tokenID;
		this.userID = userID;
		this.username = username;
		this.expiry = expiry;
	}
	private Timestamp expiry;
	public int getTokenID() {
		return tokenID;
	}
	public void setTokenID(int tokenID) {
		this.tokenID = tokenID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public Timestamp getExpiry() {
		return expiry;
	}
	public void setExpiry(Timestamp expiry) {
		this.expiry = expiry;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiry == null) ? 0 : expiry.hashCode());
		result = prime * result + tokenID;
		result = prime * result + userID;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		TokenDTO other = (TokenDTO) obj;
		if (expiry == null) {
			if (other.expiry != null)
				return false;
		} else if (!expiry.equals(other.expiry))
			return false;
		if (tokenID != other.tokenID)
			return false;
		if (userID != other.userID)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	public TokenDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
