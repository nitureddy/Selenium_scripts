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

public class QCAfterCountAPISD {
	private String endpoint;
	private RequestSpecification request;
	private Response response;
	private String token;
	private int pendingforQCcount;
	private int qccompletedcount;
	private int qcRejectedCount;

	@Given("the Base URL is {string} and the endpoint is {string} and the Quality Check authorization token")
	public void the_base_url_is_and_the_endpoint_is_and_the_quality_check_authorization_token(String url,
			String endpoint) {
		baseURI = url;
		this.endpoint = endpoint;
		token = TestUtils.generateToken("qc");
		request = given();
	}

	@When("Quality Check After Count GET api request is made")
	public void quality_check_after_count_get_api_request_is_made() {
		response = request.log().all().header(new Header("Authorization", token)).get(endpoint);
	}

	@Then("Response Status code should be {int}")
	public void response_status_code_should_be(Integer statuscode) {
		response.then().log().all().assertThat().statusCode(statuscode);
	}

	@Then("response Body should be in JSON format")
	public void response_body_should_be_in_json_format() {
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("response body should contain label {string}")
	public void response_body_should_contain_label(String label) {
		response.then().assertThat().body("data[0].label", equalTo(label));
	}

	@Then("response body should contain label Pending for QC count")
	public void response_body_should_contain_label_pending_for_qc_count() {
		pendingforQCcount = response.then().extract().jsonPath().getInt("data[0].count");
		response.then().assertThat().body("data[0].count", equalTo(pendingforQCcount));
	}
	@Then("response body should contain Label {string}")
	public void response_body_should_contain_Label(String label) {
		response.then().assertThat().body("data[1].label", equalTo(label));
	}
	
	@Then("response body should contain label QC Completed count should be incremented by one")
	public void response_body_should_contain_label_qc_completed_count_should_be_incremented_by_one() {
		qccompletedcount = response.then().extract().jsonPath().getInt("data[1].count");
		response.then().assertThat().body("data[1].count", equalTo(qccompletedcount));
	}

	@Then("response body should Label {string}")
	public void response_body_should_label(String label) {
		response.then().assertThat().body("data[2].label", equalTo(label));
	}


	@Then("response body should contain label QC Rejected count")
	public void response_body_should_contain_label_qc_rejected_count() {
		qcRejectedCount = response.then().extract().jsonPath().getInt("data[2].count");
		response.then().assertThat().body("data[2].count", equalTo(qcRejectedCount));
	}

	@Then("the response time should be less than {int} ms")
	public void the_response_time_should_be_less_than_ms(long responseTime) {
		response.then().assertThat().time(lessThan(responseTime));
	}

}
