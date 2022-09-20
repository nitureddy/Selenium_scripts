package com.feature;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;

import com.POJOAlreadyCreatedByMahesh.FDLoginPOJO;
import com.POJOAlreadyCreatedByMahesh.LoginPOJO;
import com.pojo.AssignJobPOJO;
import com.pojo.CreateJobPOJO;
import com.pojo.JobSearchPOJO;
import com.utils.TestUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class InwarrantyFlowFeature {
	private CreateJobPOJO createJobPOJO;
	private int job_Number;
	private String fdToken, supToken;
	private Response response;

	@Given("the customer  and product information")
	public void the_customer_and_product_information() {
		// Write code here that turns the phrase above into concrete actions
		baseURI = "http://139.59.91.96:9000";
		createJobPOJO = TestUtil.getCreateJobDataWithFaker();
	}

	@When("the fd logins with userName as {string} and password as {string}")
	public void the_fd_logins_with_user_name_as_and_password_as(String userName, String password) {

		fdToken = given().when().header(new Header("content-type", "application/json")).and()
				.body(new LoginPOJO(userName, password).toJson()).and().post("/v1/login").then().log().all().and()
				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
				.extract().jsonPath().getString("data.token");

	}

	@When("creates the inwarranty job for the customer")
	public void creates_the_inwarranty_job_for_the_customer() {
		// Write code here that turns the phrase above into concrete actions
		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		myHeaderList.add(new Header("Authorization", fdToken));
		response = given().when().headers(new Headers(myHeaderList)).and().body(createJobPOJO.toJson()).and()
				.post("/v1/job/create");
	}

	@Then("jobid is present in the response")
	public void jobid_is_present_in_the_response() {
		// Write code here that turns the phrase above into concrete actions
		job_Number = response.then().log().all().assertThat().statusCode(200).and()
				.body(Matchers.containsString("Job created successfully.")).extract().jsonPath().getInt("data.id");
		System.out.println(job_Number);
	}

	@Then("jobid should be a number")
	public void jobid_should_be_a_number() {
		// Write code here that turns the phrase above into concrete actions
		// important**
		Assert.assertTrue(job_Number == (int) job_Number);
	}

	@Then("job is in pending for assignment stage")
	public void job_is_in_pending_for_assignment_stage() {
		// Write code here that turns the phrase above into concrete actions
		// Write code here that turns the phrase above into concrete actions
		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		myHeaderList.add(new Header("Authorization", fdToken));
		response = given().when().headers(new Headers(myHeaderList)).and()
				.body(new JobSearchPOJO(job_Number + "").toJson()).and().post("/v1/job/search");
		String actionStatus = response.then().log().all().assertThat().and().body(Matchers.containsString("Success"))
				.extract().jsonPath().getString("data[0].mst_action_status");
		Assert.assertEquals(actionStatus, "Pending For Job Assignment");
	}

	@Then("HTTP status code should be {int}")
	public void http_status_code_should_be(Integer statusCode) {
		// Write code here that turns the phrase above into concrete actions
		response.then().assertThat().statusCode(statusCode);
	}

	@Given("supvisor logs in with userName as {string} and password as {string}")
	public void supvisor_logs_in_with_user_name_as_and_password_as(String userName, String password) {
		// Write code here that turns the phrase above into concrete actions
		supToken = given().when().header(new Header("content-type", "application/json")).and()
				.body(new LoginPOJO(userName, password).toJson()).and().post("/v1/login").then().log().all().and()
				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
				.extract().jsonPath().getString("data.token");

	}
// pass engineer id
	@Given("He should assign the job to the engineer")
	public void he_should_assign_the_job_to_the_engineer() {
		// Write code here that turns the phrase above into concrete actions
		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		myHeaderList.add(new Header("Authorization", supToken));
		given().when().headers(new Headers(myHeaderList)).and().body(new AssignJobPOJO(job_Number, 2).toJson()).and()
				.post("/v1/engineer/assign").then().assertThat().log().all()
				.body(Matchers.containsString("Engineer assigned successfully")).and().statusCode(200);
	}

	@Then("the job status should change to Pending For Repair stage")
	public void the_job_status_should_change_to_pending_for_repair_stage() {
		// Write code here that turns the phrase above into concrete actions
		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		myHeaderList.add(new Header("Authorization", fdToken));
		response = given().when().headers(new Headers(myHeaderList)).and()
				.body(new JobSearchPOJO(job_Number + "").toJson()).and().post("/v1/job/search");
		String actionStatus = response.then().log().all().assertThat().statusCode(200).and()
				.body(Matchers.containsString("Success")).extract().jsonPath().getString("data[0].mst_action_status");
		Assert.assertEquals(actionStatus, "Pending For Repair");
	}

	@Given("Engineer logs in with userName as {string} and password as {string}")
	public void engineer_logs_in_with_user_name_as_and_password_as(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("He marks the job complete with proper remark as {string}")
	public void he_marks_the_job_complete_with_proper_remark_as(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the job status should change to Pending For QC stage")
	public void the_job_status_should_change_to_pending_for_qc_stage() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
