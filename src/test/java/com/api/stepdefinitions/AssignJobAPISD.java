package com.api.stepdefinitions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.api.pojo.SupJobAssignPojo;
import com.utils.TestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AssignJobAPISD {
	private String endpoint;
	private String token;
	private RequestSpecification request;
	private Response response;

	@Given("the Base URL is {string} endpoint is {string} and the supervior authorization token")
	public void the_base_url_is_endpoint_is_and_the_supervior_authorization_token(String url, String endpoint) {
		baseURI = url;
		this.endpoint = endpoint;
		token = TestUtils.generateToken("sup");
		request = given();
	}

	@Given("the Header should Content-Type should be in {string}")
	public void the_header_should_content_type_should_be_in(String value) {
		Header header1 = new Header("Content-Type", value);
		Header header2 = new Header("Authorization", token);
		request.headers(new Headers(header1, header2));
	}
	
	@Given("the request body should contain a json object with jobId {int} and engineer ID {int}")
	public void the_request_body_should_contain_a_json_object_with_job_id_and_engineer_id(Integer jobnumber, Integer engid) {
	    request.body(new SupJobAssignPojo(jobnumber, engid).toJson());
	}


	@When("Assign Jobs POST api request is made")
	public void assign_jobs_post_api_request_is_made() {
		response = request.log().all().post(endpoint);
	}

	@Then("Response Status Code should be {int}")
	public void response_status_code_should_be(Integer statusCode) {
		response.then().log().all().assertThat().statusCode(statusCode);
	}

	@Then("response body should be in JSON FORMAT")
	public void response_body_should_be_in_json_format() {
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("response body contain Engineer message {string}")
	public void response_body_contain_engineer_message(String message) {
		response.then().assertThat().body(containsString(message));
	}

	@Then("responseTime Should be less than {int} ms")
	public void response_time_should_be_less_than_ms(long responseTime) {
		response.then().assertThat().time(lessThan(responseTime));
	}

}
