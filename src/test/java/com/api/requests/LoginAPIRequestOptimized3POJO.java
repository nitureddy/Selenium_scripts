package com.api.requests;

import static io.restassured.RestAssured.*; //static import

import com.pojo.LoginPOJO;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
 * static variable/function {block} classes import!!
 * 
 * 
 */

public class LoginAPIRequestOptimized3POJO {

	public static void main(String[] args) {

		baseURI = "http://139.59.91.96:9000";
		Response response = given().header(new Header("Content-type", "application/json"))
				.body(new LoginPOJO("iamfd", "password").toJson()).post("/v1/login");

		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		System.out.println(response.time() + "ms");

	}
}
