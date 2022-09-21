package com.feature;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;

import com.POJOAlreadyCreatedByMahesh.LoginPOJO;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class LoginFeatureDataTable {
	List<LoginPOJO> loginList = new ArrayList<LoginPOJO>();
	String token;
	Response response;

	@Given("The user credentials")
	public void the_user_credentials(DataTable dataTable) {
		baseURI = "http://139.59.91.96:9000";
		List<List<String>> data = dataTable.asLists();
//		System.out.println(data.get(0).get(0));
//		System.out.println(data.get(0).get(1));
		// loginList.add(new LoginPOJO(data.get(0).get(0), data.get(0).get(1)))

		for (List<String> list : data) {
			loginList.add(new LoginPOJO(list.get(0), list.get(1)));
		}

	}

	@When("login api request is made")
	public void login_api_request_is_made() {
		// Write code here that turns the phrase above into concrete actions
		response = given().when().header(new Header("content-type", "application/json")).and()
				.body(loginList.get(0).toJson()).and().post("/v1/login");

		token = response.then().log().all().and().extract().jsonPath().getString("data.token");
	}

	@Then("the status code is {int}")
	public void the_status_code_is(Integer statusCode) {
		// Write code here that turns the phrase above into concrete actions
		response.then().assertThat().statusCode(statusCode);
	}
}
