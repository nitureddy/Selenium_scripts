package com.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import com.utils.TestUtils;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EngBeforeCountAPISD {
	private String endpoint;
	private RequestSpecification request;
	private Response response;
	private String token;
	private int pendingforRepairCount;
	private int RepairCompletedCount;
	
	@Given("the Base URL is {string} and the endpoint is {string} and the Eng authorization token")
	public void the_base_url_is_and_the_endpoint_is_and_the_eng_authorization_token(String url, String endpoint) {
		baseURI = url;
		this.endpoint = endpoint;
		token = TestUtils.generateToken("eng");
		request = given();
	}

	@When("Eng Before Count GET api request is made")
	public void eng_before_count_get_api_request_is_made() {
		response = request.log().all().header(new Header("Authorization", token)).get(endpoint);
	}

	@Then("Response statuscode should be {int}")
	public void response_statuscode_should_be(Integer statuscode) {
		response.then().log().all().assertThat().statusCode(statuscode);
	}

	@Then("Response Body should be in JSON")
	public void response_body_should_be_in_json() {
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("response body should contain label Pending for repair {string}")
	public void response_body_should_contain_label_pending_for_repair(String label) {
		response.then().assertThat().body("data[0].label", equalTo(label));
	}

	@Then("response body should contain Pending for repair count")
	public void response_body_should_contain_pending_for_repair_count() {
		pendingforRepairCount = response.then().extract().jsonPath().getInt("data[0].count");
		response.then().assertThat().body("data[0].count", equalTo(pendingforRepairCount));
	}

	@Then("response body should contain label Repair completed {string}")
	public void response_body_should_contain_label_repair_completed(String label) {
		response.then().assertThat().body("data[1].label", equalTo(label));
	}

	@Then("response body should contain Repair completed count")
	public void response_body_should_contain_repair_completed_count() {
		RepairCompletedCount = response.then().extract().jsonPath().getInt("data[1].count");
		response.then().assertThat().body("data[1].count", equalTo(RepairCompletedCount));
	}

	@Then("Response Time should be less than {int} ms")
	public void response_time_should_be_less_than_ms(long responseTime) {
		response.then().assertThat().time(lessThan(responseTime));
	}

}
