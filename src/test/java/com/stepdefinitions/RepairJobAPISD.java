package com.stepdefinitions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

import com.api.pojo.JobRepairPojo;
import com.api.pojo.Problems;
import com.utils.TestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RepairJobAPISD {
	private String endpoint;
	private String token;
	private RequestSpecification request;
	private Response response;
	

	@Given("the Base URL is {string} endpoint is {string} and the Engineer authorization token")
	public void the_base_url_is_endpoint_is_and_the_engineer_authorization_token(String url, String endpoint) {
		baseURI = url;
		this.endpoint = endpoint;
		token = TestUtils.generateToken("eng");
		request = given();
	}

	@Given("the Header should content-type should be in {string}")
	public void the_header_should_content_type_should_be_in(String value) {
		Header header1 = new Header("Content-Type", value);
		Header header2 = new Header("Authorization", token);
		request.headers(new Headers(header1, header2));
	}

	@Given("the request body should contain a json object with job number {int} and problems")
	public void the_request_body_should_contain_a_json_object_with_job_number_and_problems(Integer JobNumber) {
		Problems[] P1 = new Problems[1];
		P1[0] = new Problems(4, "solved");
		request.body(new JobRepairPojo(JobNumber, P1).toJson());
	}

	@When("Repair Job POST api request is made")
	public void repair_job_post_api_request_is_made() {
		response = request.log().all().post(endpoint);
	}

	@Then("Response statuscode Should be {int}")
	public void response_statuscode_should_be(Integer statusCode) {
		response.then().log().all().assertThat().statusCode(statusCode);
	}

	@Then("response body should be in Json format")
	public void response_body_should_be_in_json_format() {
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("response Body contain message {string}")
	public void response_body_contain_message(String message) {
		response.then().assertThat().body(containsString(message));
	}

	@Then("Response time Should be less than {int} ms")
	public void response_time_should_be_less_than_ms(long responseTime) {
		response.then().assertThat().time(lessThan(responseTime));
	}

}
