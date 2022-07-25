package com.POJOAlreadyCreatedByMahesh;

public class EngLoginPOJO {
	private String username;
	private String password;
	public EngLoginPOJO(String username, String password) {
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
		return "EngLoginPOJO [username=" + username + ", password=" + password + "]";
	}

}
