package com.api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import com.utils.TestUtils;

import io.restassured.specification.RequestSpecification;

public class FDUserDetailsAPISD {
	private String endpoint;
	private RequestSpecification request;
	private Response response;
	private String token;
	
	@Given("the Base URL is {string} and the endpoint is {string} and the FrontDesk authorization token")
	public void the_base_url_is_and_the_endpoint_is_and_the_front_desk_authorization_token(String url, String endpoint) {
	    baseURI = url;
	    this.endpoint = endpoint;
	    token = TestUtils.generateToken("FD");
	    request = given();
	}

	@When("FrontDesk User Detail GET api request is made")
	public void front_desk_user_detail_get_api_request_is_made() {
	    response = request.log().all().header(new Header("Authorization", token)).get(endpoint);
	}
	
	@Then("response body status code should be {int}")
	public void response_body_status_code_should_be(Integer status) {
	    response.then().log().all().assertThat().statusCode(status);
	}
	@Then("Response body should be in JSON format")
	public void response_body_should_be_in_json_format() {
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("response body should contain message {string}")
	public void response_body_should_contain_message(String message) {
		response.then().assertThat().body(Matchers.containsString(message));
	}

	@Then("response body should contain login_id {string}")
	public void response_body_should_contain_login_id(String id) {
		response.then().assertThat().body(Matchers.containsString(id));
	}

	@Then("response body should contain email_id {string}")
	public void response_body_should_contain_email_id(String email) {
		response.then().assertThat().body(Matchers.containsString(email));
	}

	@Then("response body should contain mobile_number {string}")
	public void response_body_should_contain_mobile_number(String mobileNo) {
		response.then().assertThat().body(Matchers.containsString(mobileNo));
	}

	@Then("response should be less than {int} ms")
	public void response_should_be_less_than_ms(long responseTime) {
		response.then().assertThat().time(Matchers.lessThan(responseTime));
	}


}
