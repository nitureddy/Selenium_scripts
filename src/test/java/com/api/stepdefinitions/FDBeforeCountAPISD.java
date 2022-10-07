package com.api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.utils.TestUtils;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FDBeforeCountAPISD {
	private String endpoint;
	private RequestSpecification request;
	private Response response;
	private String token;
	private int deliveryCount;
	private int createCount;
	private int assignmentCount;
	
	
	@Given("the BaseURL is {string} and the endpoint is {string} and the FrontDesk authorization token")
	public void the_base_url_is_and_the_endpoint_is_and_the_front_desk_authorization_token(String url, String endpoint) {
		baseURI = url;
	    this.endpoint = endpoint;
	    token = TestUtils.generateToken("fd");
	    request = given();
	}

	@When("Before Count GET api request is made")
	public void before_count_get_api_request_is_made() {
		response = request.log().all().header(new Header("Authorization", token)).get(endpoint); 
	}

	@Then("response Status code should be {int}")
	public void response_status_code_should_be(Integer status) {
		response.then().log().all().assertThat().statusCode(status);
	}

	@Then("the response body should be in JSON format")
	public void the_response_body_should_be_in_json_format() {
	    response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("response body contain label Pending for delivery")
	public void response_body_contain_label_pending_for_delivery() {
	    response.then().assertThat().body("data[0].label", equalTo("Pending for delivery"));
	}

	@Then("response body should contain Pending for delivery count")
	public int response_body_should_contain_pending_for_delivery_count() {
	    deliveryCount= response.then().extract().jsonPath().getInt("data[0].count");
		response.then().assertThat().body("data[0].count", equalTo(deliveryCount));
		return deliveryCount;
	}

	@Then("response body should contain label Create Today")
	public void response_body_should_contain_label_create_today() {
		response.then().assertThat().body("data[1].label", equalTo("Created today"));
	}

	@Then("response body should contain Create count")
	public void response_body_should_contain_create_count() {
		createCount= response.then().extract().jsonPath().getInt("data[1].count");
		response.then().assertThat().body("data[1].count", equalTo(createCount));
	}

	@Then("response body should contain label Pending for FST assignment")
	public void response_body_should_contain_label_pending_for_fst_assignment() {
		response.then().assertThat().body("data[2].label", equalTo("Pending for FST assignment"));
	}

	@Then("response body should contain Pending for FST assignment count")
	public void response_body_should_contain_pending_for_fst_assignment_count() {
		assignmentCount= response.then().extract().jsonPath().getInt("data[2].count");
		response.then().assertThat().body("data[2].count", equalTo(assignmentCount));
	}

	@Then("response time should be less than {int} ms")
	public void response_time_should_be_less_than_ms(long responseTime) {
		response.then().assertThat().time(lessThan(responseTime));
	}


}
