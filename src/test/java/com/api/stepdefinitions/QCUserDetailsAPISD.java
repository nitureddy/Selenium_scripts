package com.api.stepdefinitions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

import com.utils.TestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QCUserDetailsAPISD {
	private String endpoint;
	private RequestSpecification request;
	private Response response;
	private String token;
	
	@Given("the Base URL is {string} and the endpoint is {string} and the QC authorization Token")
	public void the_base_url_is_and_the_endpoint_is_and_the_qc_authorization_token(String url, String endpoint) {
		baseURI = url;
	    this.endpoint = endpoint;
	    token = TestUtils.generateToken("qc");
	    request = given();
	}

	@When("Quality Check User Detail GET api request is made")
	public void quality_check_user_detail_get_api_request_is_made() {
		response = request.log().all().header(new Header("Authorization", token)).get(endpoint);
	}

	@Then("Response Statuscode should be {int}")
	public void response_statuscode_should_be(Integer statuscode) {
		response.then().log().all().assertThat().statusCode(statuscode);
	}

	@Then("response body should be in JSON Format")
	public void response_body_should_be_in_json_format() {
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("response body contain message {string}")
	public void response_body_contain_message(String message) {
		response.then().assertThat().body(containsString(message));
	}

	@Then("response body should contain Quality Check login_id {string}")
	public void response_body_should_contain_quality_check_login_id(String loginid) {
		response.then().assertThat().body(containsString(loginid));
	}

	@Then("response body should contain Quality Check email_id {string}")
	public void response_body_should_contain_quality_check_email_id(String emailid) {
		response.then().assertThat().body(containsString(emailid));
	}

	@Then("response body should contain Quality Check mobile number {string}")
	public void response_body_should_contain_quality_check_mobile_number(String mobileNo) {
		response.then().assertThat().body(containsString(mobileNo));
	}

	@Then("responseTime should be less than {int} ms")
	public void response_time_should_be_less_than_ms(long responseTime) {
		response.then().assertThat().time(lessThan(responseTime));
	}

}
