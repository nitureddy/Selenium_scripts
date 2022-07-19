package com.api.requests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPIRequestOptimized {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://139.59.91.96:9000";
		Response response = RestAssured.given().header(new Header("Content-type", "application/json"))
				.body("{\"username\":\"iamfd\",\"password\":\"password\"}").post("/v1/login");

		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		System.out.println(response.time() + "ms");

	}
}
