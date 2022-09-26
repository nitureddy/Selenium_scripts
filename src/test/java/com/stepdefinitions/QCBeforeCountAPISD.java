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

public class QCBeforeCountAPISD {
	private String endpoint;
	private RequestSpecification request;
	private Response response;
	private String token;
	private int pendingforQCcount;
	private int qccompletedcount;
	private int qcRejectedCount;
	
	
	@Given("the Base URL is {string} and the endpoint is {string} and the QC authorization token")
	public void the_base_url_is_and_the_endpoint_is_and_the_qc_authorization_token(String url, String endpoint) {
		baseURI = url;
		this.endpoint = endpoint;
		token = TestUtils.generateToken("qc");
		request = given();
	}

	@When("Quality Check Before Count GET api request is made")
	public void quality_check_before_count_get_api_request_is_made() {
		response = request.log().all().header(new Header("Authorization", token)).get(endpoint);
	}

	@Then("response status code have to be {int}")
	public void response_status_code_have_to_be(Integer statuscode) {
		response.then().log().all().assertThat().statusCode(statuscode);
	}

	@Then("response Body should be in JSON")
	public void response_body_should_be_in_json() {
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
	}

	@Then("response body contain label Pending for QC {string}")
	public void response_body_contain_label_pending_for_qc(String label) {
		response.then().assertThat().body("data[0].label", equalTo(label));
	}

	@Then("response body should contain Pending for QC count")
	public void response_body_should_contain_pending_for_qc_count() {
		pendingforQCcount = response.then().extract().jsonPath().getInt("data[0].count");
		response.then().assertThat().body("data[0].count", equalTo(pendingforQCcount));
	}

	@Then("response body contain label QC Completed {string}")
	public void response_body_contain_label_qc_completed(String label) {
		response.then().assertThat().body("data[1].label", equalTo(label));
	}

	@Then("response body should contain QC Completed count")
	public void response_body_should_contain_qc_completed_count() {
		qccompletedcount = response.then().extract().jsonPath().getInt("data[1].count");
		response.then().assertThat().body("data[1].count", equalTo(qccompletedcount));
	}

	@Then("response body contain label QC Rejected {string}")
	public void response_body_contain_label_qc_rejected(String label) {
		response.then().assertThat().body("data[2].label", equalTo(label));
	}

	@Then("response body should contain QC Rejected count")
	public void response_body_should_contain_qc_rejected_count() {
		qcRejectedCount = response.then().extract().jsonPath().getInt("data[2].count");
		response.then().assertThat().body("data[2].count", equalTo(qcRejectedCount));
	}

	@Then("response Time should be less than {int} ms")
	public void response_time_should_be_less_than_ms(long responseTime) {
		response.then().assertThat().time(lessThan(responseTime));
	}

}
