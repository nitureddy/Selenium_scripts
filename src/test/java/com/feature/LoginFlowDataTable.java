package com.feature;

import java.util.List;

import com.POJOAlreadyCreatedByMahesh.LoginPOJO;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFlowDataTable {

	@Given("user login  with valid credentials")
	public void user_login_with_valid_credentials(DataTable dataTable) {
		List<LoginPOJO> d = dataTable.asList(LoginPOJO.class);
		System.out.println(d.get(0));
	}

	@When("user makes a login request")
	public void user_makes_a_login_request() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("response code should be {int}")
	public void response_code_should_be(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("token value should not be null")
	public void token_value_should_not_be_null() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
