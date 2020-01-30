package com.simplilearn.lockme.model;

public class Users {
	private String username;
	private String Password;
	
	
	
	public Users() {
	}

	public Users(String username, String password) {
		super();
		this.username = username;
		Password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", Password=" + Password + "]";
	}
	
	

}
