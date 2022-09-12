package com.feature;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;

import com.pojo.CreateJobPOJO;
import com.pojo.LoginPOJO;
import com.utils.TestUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class InwarrantyFeature {
	private CreateJobPOJO createJobPOJO;
	private String token, suptoken;
	Response response;
	private String jobNumber;

	@Given("the customer information and product details")
	public void the_customer_information_and_product_details() {
		// Write code here that turns the phrase above into concrete actions
		createJobPOJO = TestUtil.getCreateJobDataWithFaker();

	}

	@Given("FD logins into the system")
	public void fd_logins_into_the_system() {
		baseURI = "http://139.59.91.96:9000";

		// Write code here that turns the phrase above into concrete actions
		token = given().when().header(new Header("content-type", "application/json")).and()
				.body(new LoginPOJO("iamfd", "password").toJson()).and().post("v1/login").then().log().all().and()
				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
				.extract().jsonPath().getString("data.token");
	}

	@When("FD creates the job with customer information")
	public void fd_creates_the_job_with_customer_information() {
		// Write code here that turns the phrase above into concrete actions
		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		myHeaderList.add(new Header("Authorization", token));

		response = given().when().headers(new Headers(myHeaderList)).and().body(createJobPOJO.toJson()).and()
				.post("/v1/job/create");
	}

	@Then("a jobID should be created")
	public void a_job_id_should_be_created() {
		// Write code here that turns the phrase above into concrete actions
		jobNumber = response.then().log().all().assertThat().statusCode(200).and()
				.body(Matchers.containsString("Job created successfully.")).extract().jsonPath().getString("data.id");
	}

	@When("SUP logs into the system")
	public void sup_logs_into_the_system() {
		// Write code here that turns the phrase above into concrete actions
		suptoken = given().when().header(new Header("content-type", "application/json")).and()
				.body(new LoginPOJO("iamfd", "password").toJson()).and().post("v1/login").then().log().all().and()
				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
				.extract().jsonPath().getString("data.token");
	}

	@Then("job should be in pending for assignment")
	public void job_should_be_in_pending_for_assignment() {
		// Write code here that turns the phrase above into concrete actions
		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		myHeaderList.add(new Header("Authorization", suptoken));

		response = given().when().headers(new Headers(myHeaderList)).and().body("{\"searchText\": \"JOB_16257\"}").and()
				.post("/v1/job/search");
		String actionStatus = response.then().log().all().assertThat().statusCode(200).and()
				.body(Matchers.containsString("Success")).extract().jsonPath().getString("data[0].mst_action_status");
		Assert.assertEquals(actionStatus, "Pending For Job Assignment");
	}

	@Then("Sup should assign the job to the Engineer")
	public void sup_should_assign_the_job_to_the_engineer() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("Engineer logs into the system")
	public void engineer_logs_into_the_system() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("job should be in pending for repair")
	public void job_should_be_in_pending_for_repair() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("Engineer works on the job")
	public void engineer_works_on_the_job() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("marks the job for QC")
	public void marks_the_job_for_qc() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("job should be in pending for QC")
	public void job_should_be_in_pending_for_qc() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("QC completes the jon")
	public void qc_completes_the_jon() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the job should be for pending for delivery")
	public void the_job_should_be_for_pending_for_delivery() {
		// Write code here that turns the phrase above into concrete actions
	}
}
