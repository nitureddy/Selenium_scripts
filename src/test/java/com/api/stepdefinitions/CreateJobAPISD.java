package com.api.stepdefinitions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

import com.utils.TestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJobAPISD {
	private String endpoint;
	private String token;
	private RequestSpecification request;
	private Response response;
	private JsonPath jsonpath;
	private String jobID;
	private int jobnumber;
	private int customerID;

	@Given("the Base URL is {string} and the endpoint is {string} and the FD Authorization token")
	public void the_base_url_is_and_the_endpoint_is_and_the_fd_authorization_token(String url, String endpoint) {
		baseURI = url;
		this.endpoint = endpoint;
		token = TestUtils.generateToken("fd");
		request = given();
	}

	@Given("the Header should content-type should be {string}")
	public void the_header_should_content_type_should_be(String value) {
		Header header1 = new Header("Content-Type", value);
		Header header2 = new Header("Authorization", token);
		request.headers(new Headers(header1, header2));
	}

	@Given("the request body should contain a json object with Customer, customer address, customer product and problems")
	public void the_request_body_should_contain_a_json_object_with_customer_customer_address_customer_product_and_problems() {
		request.body(TestUtils.getCreateJobData().toJson());
	}

	@When("the createjob POST api request is made")
	public void the_createjob_post_api_request_is_made() {
		response = request.log().all().post(endpoint);
	}

	@Then("Response Statuscode Should be {int} OK")
	public void response_statuscode_should_be_ok(Integer statusCode) {
		response.then().log().all().assertThat().statusCode(statusCode);
	}

	@Then("the request body should contain a json object")
	public void the_request_body_should_contain_a_json_object() {
		jsonpath = response.then().assertThat().header("Content-Type", "application/json; charset=utf-8").and()
				.extract().jsonPath();
	}

	@Then("the response body contain the message as {string}")
	public void the_response_body_contain_the_message_as(String message) {
		response.then().assertThat().body(containsString(message));
	}

	@Then("the response body should contain the job id")
	public void the_response_body_should_contain_the_job_id() {
		jobID = jsonpath.and().getString("data.job_number");
		response.then().assertThat().body("data.job_number", Matchers.equalTo(jobID));
	}

	@Then("the response body should contain the job_number")
	public void the_response_body_should_contain_the_job_number() {
		jobnumber = jsonpath.and().getInt("data.id");
		response.then().assertThat().body("data.id", Matchers.equalTo(jobnumber));
	}

	@Then("the customer id should be created")
	public void the_customer_id_should_be_created() {
		customerID = jsonpath.and().getInt("data.tr_customer_id");
		response.then().assertThat().body("data.tr_customer_id", Matchers.equalTo(customerID));
	}

	@Then("response should be available with in {int} ms")
	public void response_should_be_available_with_in_ms(long responseTime) {
		response.then().assertThat().time(lessThan(responseTime));
	}

}
