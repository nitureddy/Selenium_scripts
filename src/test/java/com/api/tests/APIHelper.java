package com.api.tests;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import com.pojo.IBody;
import com.pojo.LoginPOJO;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class APIHelper {

	/*
	 * makeRequest 1. baseurl 2.endpoint 3.httpverb 4.body 5.header
	 * 
	 */

	public APIHelper() {
		// TODO Auto-generated constructor stub

		baseURI = "http://139.59.91.96:9000";
	}

	public APIHelper(String url) {
		// TODO Auto-generated constructor stub

		baseURI = url;
	}

	public Response makeAPIRequest(String endpoint, Verb verb, IBody body, Header... header) {
		// decoupling : All the pojos were implememting ibody interface and -- to json()

		Response response = null;

		System.out.println(endpoint);
		System.out.println(verb);
		System.out.println(body.toJson());
		System.out.println(header[0]);
		if (verb == Verb.POST) {

			response = given().when().headers(new Headers(header)).and().body(body.toJson()).and().post(endpoint);
		} else if (verb == Verb.PUT)
			response = given().when().headers(new Headers(header)).and().body(body.toJson()).and().put(endpoint);
		response.then().log().all();
		return response;
	}

	public Response makeAPIRequest(String endpoint, Verb verb, Header... header) {
		// decoupling : All the pojos were implememting ibody interface and -- to json()

		Response response = null;

		System.out.println(endpoint);
		System.out.println(verb);

		System.out.println(header[0]);
		if (verb == Verb.GET) {

			response = given().when().headers(new Headers(header)).and().post(endpoint);
		} else if (verb == Verb.DELETE)
			response = given().when().headers(new Headers(header)).and().delete(endpoint);
		response.then().log().all();
		return response;
	}

}
