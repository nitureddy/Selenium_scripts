package com.stepdefinitions;

import static org.hamcrest.Matchers.*;
import com.api.pojo.Job_Search;
import com.utils.TestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


/**
 *Shift +Alt+J
 * @author Jatin
 *
 */
public class SearchAPISD {

	private String endpoint;
	private String token;
	private RequestSpecification request;
	private Response response;

	@Given("the Base URL is {string} and the endpoint is {string} and authorization token")
	public void the_base_url_is_and_the_endpoint_is_and_authorization_token(String url, String endpoint) {
		baseURI = url;
		this.endpoint = endpoint;
		token = TestUtils.generateToken();
		request = given();
	}

	@Given("the Header should content-Type should be in {string}")
	public void the_header_should_content_type_should_be_in(String value) {
		Header header1 = new Header("Content-Type", value);
		Header header2 = new Header("Authorization", token);
		request.headers(new Headers(header1, header2));

	}

	@Given("the request body should contain a json object with the job id {string}")
	public void the_request_body_should_contain_a_json_object_with_the_job_id(String jobId) {
		request.body(new Job_Search(jobId).toJson());
	}

	@When("Search POST api request is made")
	public void search_api_request_is_made() {
		response = request.log().all().post(endpoint);
	}

	@Then("response should be in Json")
	public void response_should_be_in_json() {
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer statusCode) {
		response.then().log().all().assertThat().statusCode(statusCode);
	}

	@Then("the response body should contain the message as {string}")
	public void the_response_body_should_contain_the_message_as(String message) {
		response.then().assertThat().body(containsString(message));
	}

	@Then("the response body should contain the job number {string}")
	public void the_response_body_should_contain_the_job_number(String jobnumber) {
		// Write code here that turns the phrase above into concrete actions
		response.then().assertThat().body(containsString(jobnumber));
	}

	@Then("the response body should contain the job id {int}")
	public void the_response_body_should_contain_the_job_id(Integer jobId) {

		response.then().assertThat().body("data[0].id", equalTo(jobId));
	}

	@Then("the response body should be mst_warrenty_status_code {string}")
	public void the_response_body_should_be_mst_warrenty_status_code(String warrantyStatusCode) {
		response.then().assertThat().body("data[0].mst_warrenty_status_code", equalTo(warrantyStatusCode));
	}

	@Then("response should be available in less than {int} ms")
	public void response_should_be_available_in_less_than_ms(long responseTime) {
		response.then().assertThat().time(lessThan(responseTime));
	}

}
