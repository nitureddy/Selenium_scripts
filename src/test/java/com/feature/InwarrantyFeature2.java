//package com.feature;
//
//import static io.restassured.RestAssured.baseURI;
//import static io.restassured.RestAssured.given;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hamcrest.Matchers;
//import org.testng.Assert;
//
//import com.POJOAlreadyCreatedByMahesh.FDLoginPOJO;
//import com.pojo.AssignJobPOJO;
//import com.pojo.CreateJobPOJO;
//import com.pojo.JobSearchPOJO;
//import com.pojo.LoginPOJO;
//import com.utils.TestUtil;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.http.Header;
//import io.restassured.http.Headers;
//import io.restassured.response.Response;
//
//public class InwarrantyFeature2 {
//	private CreateJobPOJO createJobPOJO;
//	private int job_Number;
//	private String fdToken, supToken;
//	private Response response;
//
//	@Given("the customer  and product information")
//	public void the_customer_and_product_information() {
//		// Write code here that turns the phrase above into concrete actions
//		baseURI = "http://139.59.91.96:9000";
//		createJobPOJO = TestUtil.getCustomerAndProductData();
//
//	}
//
//	@When("the fd logins")
//	public void the_fd_logins() {
//		// Write code here that turns the phrase above into concrete actions
//
//		fdToken = given().when().header(new Header("content-type", "application/json")).and()
//				.body(new FDLoginPOJO("iamfd", "password").toJson()).and().post("/v1/login").then().log().all().and()
//				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
//				.extract().jsonPath().getString("data.token");
//
//	}
//
//	@When("creates the inwarranty job for the customer")
//	public void creates_the_inwarranty_job_for_the_customer() {
//		List<Header> myHeaderList = new ArrayList<Header>();
//		myHeaderList.add(new Header("content-type", "application/json"));
//		myHeaderList.add(new Header("Authorization", fdToken));
//		response = given().when().headers(new Headers(myHeaderList)).and().body(createJobPOJO.toJson()).and()
//				.post("/v1/job/create");
//
//	}
//
//	@Then("jobid is present in the response")
//	public void jobid_is_present_in_the_response() {
//		// Write code here that turns the phrase above into concrete actions
//		job_Number = response.then().log().all().assertThat().statusCode(200).and()
//				.body(Matchers.containsString("Job created successfully.")).extract().jsonPath().getInt("data.id");
//		System.out.println(job_Number);
//	}
//
//	@Then("job is in pending for assignment stage")
//	public void job_is_in_pending_for_assignment_stage() {
//		// Write code here that turns the phrase above into concrete actions
//		List<Header> myHeaderList = new ArrayList<Header>();
//		myHeaderList.add(new Header("content-type", "application/json"));
//		myHeaderList.add(new Header("Authorization", fdToken));
//		response = given().when().headers(new Headers(myHeaderList)).and()
//				.body(new JobSearchPOJO(job_Number + "").toJson()).and().post("/v1/job/search");
//		String actionStatus = response.then().log().all().assertThat().statusCode(200).and()
//				.body(Matchers.containsString("Success")).extract().jsonPath().getString("data[0].mst_action_status");
//		Assert.assertEquals(actionStatus, "Pending For Job Assignment");
//	}
//
//	@When("supvisor logs in")
//	public void supvisor_logs_in() {
//		supToken = given().when().header(new Header("content-type", "application/json")).and()
//				.body(new LoginPOJO("iamsup", "password").toJson()).and().post("/v1/login").then().log().all().and()
//				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
//				.extract().jsonPath().getString("data.token");
//	}
//
//	@When("supvisor should assign the job to the engineer")
//	public void supvisor_should_assign_the_job_to_the_engineer() {
//		// Write code here that turns the phrase above into concrete actions
//
//		List<Header> myHeaderList = new ArrayList<Header>();
//		myHeaderList.add(new Header("content-type", "application/json"));
//		myHeaderList.add(new Header("Authorization", supToken));
//		given().when().headers(new Headers(myHeaderList)).and().body(new AssignJobPOJO(job_Number, 2).toJson()).and()
//				.post("/v1/engineer/assign").then().assertThat().log().all()
//				.body(Matchers.containsString("Engineer assigned successfully")).and().statusCode(200);
//
//	}
//
//	@Then("the job status should change to Pending For Repair")
//	public void the_job_status_should_change_to_pending_for_repair() {
//		// Write code here that turns the phrase above into concrete actions
//		List<Header> myHeaderList = new ArrayList<Header>();
//		myHeaderList.add(new Header("content-type", "application/json"));
//		myHeaderList.add(new Header("Authorization", fdToken));
//		response = given().when().headers(new Headers(myHeaderList)).and()
//				.body(new JobSearchPOJO(job_Number + "").toJson()).and().post("/v1/job/search");
//		String actionStatus = response.then().log().all().assertThat().statusCode(200).and()
//				.body(Matchers.containsString("Success")).extract().jsonPath().getString("data[0].mst_action_status");
//		Assert.assertEquals(actionStatus, "Pending For Repair");
//
//	}
//
//}
