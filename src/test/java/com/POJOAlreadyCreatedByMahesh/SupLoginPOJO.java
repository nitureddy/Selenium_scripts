package com.POJOAlreadyCreatedByMahesh;

import com.google.gson.Gson;

public class SupLoginPOJO implements IBody {
	private String username;
	private String password;
	public SupLoginPOJO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
		return "SupLoginPOJO [username=" + username + ", password=" + password + "]";
	}
	public String toJson() {
		SupLoginPOJO supLogin = new SupLoginPOJO(username, password);
		Gson gson = new Gson();
		return gson.toJson(supLogin);
		
	}

}
