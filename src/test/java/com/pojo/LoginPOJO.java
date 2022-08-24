package com.pojo;

import com.google.gson.Gson;

public class LoginPOJO implements IBody {
	private String userRole;
	private String username;
	private String password;

	public LoginPOJO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginPOJO(String userRole, String username, String password) { //secondary
		super();
		this.userRole = userRole;
		this.username = username;
		this.password = password;
	}

	
	
	
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginAPIEng [username=" + username + ", password=" + password + "]";
	}

	public String toJson() {
		// TODO Auto-generated method stub
		LoginPOJO loginPojo = new LoginPOJO(username, password);
		Gson gson = new Gson();
		String data = gson.toJson(loginPojo);
		return data;
	}

}
