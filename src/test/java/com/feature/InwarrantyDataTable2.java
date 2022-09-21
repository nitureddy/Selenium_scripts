//package com.feature;
//
//import java.util.List;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class InwarrantyDataTable2 {
//
//
//	@Given("user login  with username {string} and password as {string}")
//	public void user_login_with_username_and_password_as(String string, String string2) {
//	    // Write code here that turns the phrase above into concrete actions
//	 
//	}
//
//	
//
//	@When("create job api request is made with the customer info")
//	public void create_job_api_request_is_made_with_the_customer_info(DataTable dataTable) {
//		List<List<String>> data = dataTable.asLists();
//		System.out.println(data.get(0).get(1));
//	}
//
//	
//	@Then("the jobid should be created")
//	public void the_jobid_should_be_created() {
//	    // Write code here that turns the phrase above into concrete actions
//	   
//	}
//}
