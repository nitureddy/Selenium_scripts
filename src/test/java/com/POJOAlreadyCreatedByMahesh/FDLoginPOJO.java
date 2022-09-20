package com.POJOAlreadyCreatedByMahesh;

import com.google.gson.Gson;
import com.pojo.IBody;

public class FDLoginPOJO implements IBody {
	private String username;
	private String password;

	public FDLoginPOJO(String username, String password) {

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
		return "FDLoginPOJO [username=" + username + ", password=" + password + "]";
	}

	public String toJson() {
		FDLoginPOJO fdLogin = new FDLoginPOJO(username, password);
		Gson gson = new Gson();
		return gson.toJson(fdLogin);

	}

}