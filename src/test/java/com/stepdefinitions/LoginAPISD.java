package com.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import com.api.pojo.PhoenixLoginCredentialsPOJO;

/**
 * 
 * The {@code LoginAPISD} class the Step Definition for the LoginAPI.geature
 * 
 * <p>
 * If you want to add a StepDefinition please create them inside
 * src/test/java/com.stepdefinitions. Please attach the featuresfiles in the
 * src/test/resoures/features
 * </p>
 * 
 * @author Jatin
 * @tag UAT Test
 *
 */
public class LoginAPISD {
	private String endpoint;
	private RequestSpecification request;
	private Response response;
	private JsonPath jsonpath;
	private String token;

	@Given("the Base URL is {string} and the endpoint is {string}")
	public void the_base_url_is_and_the_endpoint_is(String url, String endpoint) {
		baseURI = url;
		this.endpoint = endpoint;
		request = given();
	}

	@Given("the Header should have content-Type {string}")
	public void the_header_should_have_content_type(String type) {

		request.header(new Header("content-Type", type));
	}

	@Given("the request body should contain a json object with the credentials username and password")
	public void the_request_body_should_contain_a_json_object_with_the_credentials_username_and_password() {

		request.body(new PhoenixLoginCredentialsPOJO("iamfd", "password").toJson());
	}

	@When("login POST api request is made")
	public void login_post_api_request_is_made() {

		response = request.log().all().post(endpoint);
	}

	@Then("response status code should be {int}")
	public void response_status_code_should_be(Integer status) {

		response.then().log().all().assertThat().statusCode(status);
	}

	@Then("response body should be in JSON format")
	public void response_body_should_be_in_json_format() {
		jsonpath = response.then().assertThat().header("Content-Type", "application/json; charset=utf-8").extract()
				.jsonPath();
	}

	@Then("response body should contain message as {string}")
	public void response_body_should_contain_message_as(String message) {
		response.then().assertThat().body(containsString(message));
	}

	@Then("response body should contain a valid token")
	public void response_body_should_contain_a_valid_token() {
		token = jsonpath.getString("data.token");
	}

	@Then("the execution time should be less then {int} ms")
	public void the_execution_time_should_be_less_then_ms(long executiontime) {
		response.then().assertThat().time(lessThan(executiontime));
	}

}
