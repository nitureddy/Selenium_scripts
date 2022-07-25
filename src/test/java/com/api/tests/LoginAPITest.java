package com.api.tests;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pojo.LoginPOJO;

import io.restassured.http.Header;

public class LoginAPITest {
	//

	private String token;

	@BeforeMethod(description = "intializing  the baseURI for api testing")
	public void setup() {
		baseURI = "http://139.59.91.96:9000";

	}

	@Test(description = "verify if login API request is working or not", groups = { "sanity", "smoke", "e2e", "api",
			"regression" }, priority = 1)
	public void verifyLoginAPI() {

		token = given().when().header(new Header("content-type", "application/json")).and()
				.body(new LoginPOJO("iamfd", "password").toJson()).and().post("v1/login").then().log().all().and()
				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
				.extract().jsonPath().getString("data.token");
		System.out.println("-------------" + token);
	}

	@Test(description = "verify if create job API request is working or not", groups = { "sanity", "smoke", "e2e",
			"api", "regression" }, priority = 2)
	public void createJobAPITest() {

	}

}
