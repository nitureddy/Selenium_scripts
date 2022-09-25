package com.api.pojo;

import com.google.gson.Gson;

public final class PhoenixLoginCredentialsPOJO implements IBodyJson{
private String username;
private String password;

public PhoenixLoginCredentialsPOJO(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
@Override
public String toString() {
	return "Phoenix_Login_Credentials_POJO [username=" + username + ", password=" + password + "]";
}
public String toJson() {
	// TODO Auto-generated method stub
	PhoenixLoginCredentialsPOJO P = new PhoenixLoginCredentialsPOJO(username, password);
	Gson g = new Gson();
	return g.toJson(P);
}

}
