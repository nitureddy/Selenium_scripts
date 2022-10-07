package com.api.stepdefinitions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.api.pojo.JobCompletedPojo;
import com.utils.TestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QCJobCompletedAPISD {
	private String endpoint;
	private String token;
	private RequestSpecification request;
	private Response response;

	
	@Given("the Base URL is {string} endpoint is {string} and the Quality Check authorization token")
	public void the_base_url_is_endpoint_is_and_the_quality_check_authorization_token(String url, String endpoint) {
		baseURI = url;
		this.endpoint = endpoint;
		token = TestUtils.generateToken("qc");
		request = given();
	}

	@Given("Header should content-type should be in {string}")
	public void header_should_content_type_should_be_in(String value) {
		Header header1 = new Header("Content-Type", value);
		Header header2 = new Header("Authorization", token);
		request.headers(new Headers(header1, header2));
	}

	@Given("the request body should contain a json object with the job number {int}")
	public void the_request_body_should_contain_a_json_object_with_the_job_number(Integer jobnumber) {
	    request.body(new JobCompletedPojo(jobnumber).toJson());
	}

	@When("Quality Check Job Completed POST api request is made")
	public void quality_check_job_completed_post_api_request_is_made() {
		response = request.log().all().post(endpoint);
	}

	@Then("Response Statuscode Should be {int}")
	public void response_statuscode_should_be(Integer statusCode) {
		response.then().log().all().assertThat().statusCode(statusCode);
	}

	@Then("response body is in JSON Format")
	public void response_body_is_in_json_format() {
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("response Body contain Message {string}")
	public void response_body_contain_message(String message) {
		response.then().assertThat().body(containsString(message));
	}

	@Then("response Should be available in less than {int} ms")
	public void response_should_be_available_in_less_than_ms(long responseTime) {
		response.then().assertThat().time(lessThan(responseTime));
	}


}
