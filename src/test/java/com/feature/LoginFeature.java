package com.feature;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

import com.POJOAlreadyCreatedByMahesh.FDLoginPOJO;
import com.pojo.IBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;

public class LoginFeature {
	String endpoint;
	IBody requestBody;

	@Given("backend URL and endpoint")
	public void backend_url_and_endpoint() {
		// Write code here that turns the phrase above into concrete actions
		baseURI = "http://139.59.91.96:9000";
		endpoint = "/v1/login";
	}

	@When("user enters their credentials")
	public void user_enters_their_credentials() {
		requestBody = new FDLoginPOJO("iamfd", "password");

	}

	@Then("token should be generated with message as success")
	public void token_should_be_generated_with_message_as_success() {
		given().when().header(new Header("content-type", "application/json")).and()
				.body(new FDLoginPOJO("iamfd", "password").toJson()).and().post(endpoint).then().log().all().and()
				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success"));
	}

}
