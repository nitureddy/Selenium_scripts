package com.InwarrantyFlow;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import com.pojo.LoginPOJO;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginFD {
	public String token;
	

	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";
		String response = given().header(new Header("Content-type", "application/json"))
				.body(new LoginPOJO("iamfd", "password").toJson()).post("/v1/login").asString();


		
		

	}

}
