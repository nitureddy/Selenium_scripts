package com.stepdefinitions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

import com.utils.TestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EngUserDetailsAPISD {
	private String endpoint;
	private RequestSpecification request;
	private Response response;
	private String token;
	
	@Given("the Base URL is {string} and the endpoint is {string} and the Engineer authorization token")
	public void the_base_url_is_and_the_endpoint_is_and_the_engineer_authorization_token(String url, String endpoint) {
		baseURI = url;
	    this.endpoint = endpoint;
	    token = TestUtils.generateToken("eng");
	    request = given();
	}

	@When("Engineer User Detail GET api request is made")
	public void engineer_user_detail_get_api_request_is_made() {
	    response = request.log().all().header(new Header("Authorization", token)).get(endpoint);
	}

	@Then("response statuscode should be {int}")
	public void response_statuscode_should_be(Integer status) {
		response.then().log().all().assertThat().statusCode(status);
	}

	@Then("response body should be in JSON")
	public void response_body_should_be_in_json() {
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("response Body should contain message {string}")
	public void response_body_should_contain_message(String message) {
		response.then().assertThat().body(Matchers.containsString(message));
	}

	@Then("response Body should contain login_id {string}")
	public void response_body_should_contain_login_id(String id) {
		response.then().assertThat().body(Matchers.containsString(id));
	}

	@Then("response body should contain email id {string}")
	public void response_body_should_contain_email_id(String email) {
		response.then().assertThat().body(Matchers.containsString(email));
	}

	@Then("response Body should contain mobile_number {string}")
	public void response_body_should_contain_mobile_number(String mobileNo) {
		response.then().assertThat().body(Matchers.containsString(mobileNo));
	}

	@Then("response Should be less than {int} ms")
	public void response_should_be_less_than_ms(long responseTime) {
		response.then().assertThat().time(Matchers.lessThan(responseTime));
	}


}
