package com.api.stepdefinitions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

import com.api.pojo.DeliverToCustomer;
import com.utils.TestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeliveryToCustomerAPISD {
	private String endpoint;
	private String token;
	private RequestSpecification request;
	private Response response;
	
	
	@Given("the Base URL is {string} and the endpoint is {string} and the Delivery Authorization token")
	public void the_base_url_is_and_the_endpoint_is_and_the_delivery_authorization_token(String url, String endpoint) {
		baseURI = url;
		this.endpoint = endpoint;
		token = TestUtils.generateToken("fd");
		request = given();
	}

	@Given("the Header should Content-type should be in {string}")
	public void the_header_should_content_type_should_be_in(String value) {
		Header header1 = new Header("Content-Type", value);
		Header header2 = new Header("Authorization", token);
		request.headers(new Headers(header1, header2));
	}

	@Given("the request body should contain a json object with job number {int}")
	public void the_request_body_should_contain_a_json_object_with_job_number(Integer jobnumber) {
	    request.body(new DeliverToCustomer(jobnumber).toJson());	}

	@When("Delivery To Customer POST api request is made")
	public void delivery_to_customer_post_api_request_is_made() {
		response = request.log().all().post(endpoint);
	}

	@Then("response statuscode Should be {int}")
	public void response_statuscode_should_be(Integer statusCode) {
		response.then().log().all().assertThat().statusCode(statusCode);
	}

	@Then("Response Body should be in JSON format")
	public void response_body_should_be_in_json_format() {
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("response body contain Delivered message {string}")
	public void response_body_contain_delivered_message(String message) {
		response.then().assertThat().body(containsString(message));
	}

	@Then("response time should be available in less than {int} ms")
	public void response_time_should_be_available_in_less_than_ms(long responseTime) {
		response.then().assertThat().time(lessThan(responseTime));
	}


}
