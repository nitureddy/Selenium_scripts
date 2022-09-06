package com.featuretest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

import com.POJOAlreadyCreatedByMahesh.FDLoginPOJO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class LoginTest {
	String endpoint;
	Response reponse;

	@Given("backend url and login endpoint")
	public void backend_url_and_login_endpoint() {
		// Write code here that turns the phrase above into concrete actions
		baseURI = "http://139.59.91.96:9000";
		endpoint = "/v1/login";
	}

	@When("a valid user enters their credentials")
	public void a_valid_user_enters_their_credentials() {
		// Write code here that turns the phrase above into concrete actions

		reponse = given().when().header(new Header("content-type", "application/json")).and()
				.body(new FDLoginPOJO("iamfd", "password").toJson()).and().post(endpoint);

	}

	@Then("the reponse status code is {int}")
	public void the_reponse_status_code_is(Integer statusCode) {
		// Write code here that turns the phrase above into concrete actions
		reponse.then().log().all().statusCode(statusCode);
	}
}
