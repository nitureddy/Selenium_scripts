package com.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import com.api.pojo.PhoenixLoginCredentialsPOJO;

public class LoginAPISD {
	private String endpoint;
	private RequestSpecification request;
	private Response response;
	private JsonPath jsonpath;
	private String token;
	
	@Given("the Base URL is {string} and the endpoint is {string}")
	public void the_base_url_is_and_the_endpoint_is(String url, String endpoint) {
	    // Write code here that turns the phrase above into concrete actions
	    baseURI = url;
	    this.endpoint = endpoint;
	    request = given();
	}

	@Given("the Header should have content-Type {string}")
	public void the_header_should_have_content_type(String type) {
	    // Write code here that turns the phrase above into concrete actions
		request.header(new Header("content-Type", type));	    
	}

	@Given("the request body should contain a json object with the credentials username and password")
	public void the_request_body_should_contain_a_json_object_with_the_credentials_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    request.body(new PhoenixLoginCredentialsPOJO("iamfd", "password").toJson());
	}

	@When("login POST api request is made")
	public void login_post_api_request_is_made() {
	    // Write code here that turns the phrase above into concrete actions
	    response = request.post(endpoint);
	}

	@Then("response status code should be {int}")
	public void response_status_code_should_be(Integer status) {
	    // Write code here that turns the phrase above into concrete actions
	    response.then().assertThat().statusCode(status);
	}

	@Then("response body should be in JSON format")
	public void response_body_should_be_in_json_format() {
	    // Write code here that turns the phrase above into concrete actions
	    jsonpath = response.then().extract().jsonPath();
	}

	@Then("response body should contain message as {string}")
	public void response_body_should_contain_message_as(String message) {
	    // Write code here that turns the phrase above into concrete actions
	    response.then().assertThat().body(Matchers.containsString(message));
	}

	@Then("response body should contain a valid token")
	public void response_body_should_contain_a_valid_token() {
	    // Write code here that turns the phrase above into concrete actions
	    token = jsonpath.getString("data.token");
	}
	
	@Then("the execution time should be less then {int} ms")
	public void the_execution_time_should_be_less_then_ms(long executiontime) {
	    // Write code here that turns the phrase above into concrete actions
		response.then().assertThat().time(Matchers.lessThan(executiontime));
	}
	

}
