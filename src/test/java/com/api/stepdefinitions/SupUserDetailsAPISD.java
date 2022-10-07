package com.api.stepdefinitions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

import com.utils.TestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SupUserDetailsAPISD {
	private String endpoint;
	private RequestSpecification request;
	private Response response;
	private String token;
	
	@Given("the Base URL is {string} and the endpoint is {string} and the Supervior authorization token")
	public void the_base_url_is_and_the_endpoint_is_and_the_supervior_authorization_token(String url, String endpoint) {
		baseURI = url;
	    this.endpoint = endpoint;
	    token = TestUtils.generateToken("sup");
	    request = given();
	}

	@When("Supervior User Detail GET api request is made")
	public void supervior_user_detail_get_api_request_is_made() {
		response = request.log().all().header(new Header("Authorization", token)).get(endpoint);
	}

	@Then("response statusCode should be {int}")
	public void response_status_code_should_be(Integer statuscode) {
		response.then().log().all().assertThat().statusCode(statuscode);
	}

	@Then("response Body should be in Json")
	public void response_body_should_be_in_json() {
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("response body should contain Message {string}")
	public void response_body_should_contain_message(String message) {
		response.then().assertThat().body(containsString(message));
	}

	@Then("response body should contain Supervior login id {string}")
	public void response_body_should_contain_supervior_login_id(String loginid) {
		response.then().assertThat().body(containsString(loginid));
	}

	@Then("response body should contain Supervior email id {string}")
	public void response_body_should_contain_supervior_email_id(String emailid) {
		response.then().assertThat().body(containsString(emailid));
	}

	@Then("response body should contain Supervior mobile number {string}")
	public void response_body_should_contain_supervior_mobile_number(String mobileNo) {
		response.then().assertThat().body(containsString(mobileNo));
	}

	@Then("response should be not more than {int} ms")
	public void response_should_be_not_more_than_ms(long responseTime) {
		response.then().assertThat().time(lessThan(responseTime));
	}


}
