package com.api.stepdefinitions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.utils.TestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeliveryUserDetailsAPISD {
	private String endpoint;
	private RequestSpecification request;
	private Response response;
	private String token;

	@Given("the Base URL is {string} and the endpoint is {string} and the Delivery authorization token")
	public void the_base_url_is_and_the_endpoint_is_and_the_delivery_authorization_token(String url,
			String endpoint) {
		baseURI = url;
	    this.endpoint = endpoint;
	    token = TestUtils.generateToken("fd");
	    request = given();
	}

	@When("Delivery User Detail api GET request is made")
	public void delivery_user_detail_api_get_request_is_made() {
		response = request.log().all().header(new Header("Authorization", token)).get(endpoint);
	}

	@Then("response StatusCode should be {int}")
	public void response_status_code_should_be(Integer statuscode) {
		response.then().log().all().assertThat().statusCode(statuscode);
	}

	@Then("Response Body should be in JSON Format")
	public void response_body_should_be_in_json_format() {
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("response body contain Message {string}")
	public void response_body_contain_message(String message) {
		response.then().assertThat().body(containsString(message));
	}

	@Then("response body should contain Delivery user login_id {string}")
	public void response_body_should_contain_delivery_user_login_id(String loginid) {
		response.then().assertThat().body(containsString(loginid));
	}

	@Then("response body should contain Delivery user email_id {string}")
	public void response_body_should_contain_delivery_user_email_id(String email) {
		response.then().assertThat().body(containsString(email));
	}

	@Then("response body should contain Delivery user mobile_number {string}")
	public void response_body_should_contain_delivery_user_mobile_number(String mobileNo) {
		response.then().assertThat().body(containsString(mobileNo));
	}

	@Then("response time should not be more than {int} ms")
	public void response_time_should_not_be_more_than_ms(long responseTime) {
		response.then().assertThat().time(lessThan(responseTime));
	}

}
