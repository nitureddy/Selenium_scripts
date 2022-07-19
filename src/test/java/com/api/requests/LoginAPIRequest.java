package com.api.requests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPIRequest {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://139.59.91.96:9000";

		// I want to make a request
		RequestSpecification request = RestAssured.given();
		Header myheader = new Header("Content-Type", "application/json");
		request.header(myheader); // attached a header of content-type -application/json to my request
									// specification
		request.body("{\"username\":\"iamfd\",\"password\":\"password\"}");// attached a request body to my request
																			// specification
		Response response = request.post("/v1/login");
		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		System.out.println(response.time() + "ms");
	}
}
