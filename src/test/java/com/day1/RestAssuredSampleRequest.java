package com.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredSampleRequest {

	/*
	 * 5 1.BaseUrl 2.Header 3.Endpoint 4. httpVerb 5.Body
	 * 
	 * 
	 */
	public static void main(String[] args) {
		RestAssured.baseURI = "http://www.google.com";
		// I am to make a request
		RequestSpecification x = RestAssured.given();
		Response y = x.get();
		System.out.println(y.getStatusCode());
		System.out.println(y.asPrettyString());
	}
}
