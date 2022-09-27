package com.stepdefinitions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.utils.TestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SupAfterCountAPISD {
	private String endpoint;
	private RequestSpecification request;
	private Response response;
	private String token;
	private int pendingForDeliveryCount;
	private int pendingForAssignmentCount;
	private int pendingForRepairCount;
	
	
	@Given("the Base URL is {string} and the endpoint is {string} and the Supervior Authorization token")
	public void the_base_url_is_and_the_endpoint_is_and_the_supervior_authorization_token(String url, String endpoint) {
		baseURI = url;
		this.endpoint = endpoint;
		token = TestUtils.generateToken("sup");
		request = given();
	}

	@When("Supervior After Count GET api request is made")
	public void supervior_after_count_get_api_request_is_made() {
		response = request.log().all().header(new Header("Authorization", token)).get(endpoint);
	}

	@Then("Response status Code should be {int}")
	public void response_status_code_should_be(Integer statuscode) {
		response.then().log().all().assertThat().statusCode(statuscode);
	}

	@Then("response body Should be in Json")
	public void response_body_should_be_in_json() {
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("response body contain label Pending for assignment {string}")
	public void response_body_contain_label_pending_for_assignment(String label) {
		response.then().assertThat().body("data[0].label", equalTo(label));
	}

	@Then("response body contain label Pending for assignment count")
	public void response_body_contain_label_pending_for_assignment_count() {
		pendingForAssignmentCount = response.then().extract().jsonPath().getInt("data[0].count");
		response.then().assertThat().body("data[0].count", equalTo(pendingForAssignmentCount));
	}

	@Then("response Body contain Label Pending for repair {string}")
	public void response_body_contain_label_pending_for_repair(String label) {
		response.then().assertThat().body("data[1].label", equalTo(label));
	}

	@Then("response body contain label Pending for repair count is incremented by one")
	public void response_body_contain_label_pending_for_repair_count_is_incremented_by_one() {
		pendingForRepairCount = response.then().extract().jsonPath().getInt("data[1].count");
		response.then().assertThat().body("data[1].count", equalTo(pendingForRepairCount));
	}

	@Then("response body contain label Pending for delivery {string}")
	public void response_body_contain_label_pending_for_delivery(String label) {
		response.then().assertThat().body("data[2].label", equalTo(label));
	}

	@Then("response body contain label Pending for delivery count")
	public void response_body_contain_label_pending_for_delivery_count() {
		pendingForDeliveryCount = response.then().extract().jsonPath().getInt("data[2].count");
		response.then().assertThat().body("data[2].count", equalTo(pendingForDeliveryCount));
	}

	@Then("responsetime should be less than {int} ms")
	public void responsetime_should_be_less_than_ms(long responseTime) {
		response.then().assertThat().time(lessThan(responseTime));
	}

}
