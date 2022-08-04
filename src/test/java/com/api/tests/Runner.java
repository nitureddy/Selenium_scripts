package com.api.tests;

import static io.restassured.RestAssured.given;

import com.pojo.LoginPOJO;
import com.pojo.ProblemPOJO;
import com.pojo.RepairJobPOJO;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class Runner {
	public static void main(String[] args) {
		APIHelper helper = new APIHelper();
		Response response = helper.makeAPIRequest("v1/login", Verb.POST, new LoginPOJO("iamfd", "password"),
				new Header("content-type", "application/json"));
		System.out.println(response.asPrettyString());

	}

}