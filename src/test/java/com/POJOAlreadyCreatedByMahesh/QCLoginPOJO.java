package com.POJOAlreadyCreatedByMahesh;

import com.google.gson.Gson;

public class QCLoginPOJO implements IBody {
	private String username;
	private String password;
	public QCLoginPOJO(String username, String password) {
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
		return "QCLoginPOJO [username=" + username + ", password=" + password + "]";
	}
	public String toJson() {
		QCLoginPOJO qcLogin = new QCLoginPOJO(username, password);
		Gson gson = new Gson();
		return gson.toJson(qcLogin);
	}
	

}
