package com.api.tests;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pojo.CreateJobPOJO;
import com.pojo.CustomerAddressPOJO;
import com.pojo.CustomerPOJO;
import com.pojo.CustomerProductPOJO;
import com.pojo.LoginPOJO;
import com.pojo.ProblemPOJO;
import com.utils.TestUtil;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class InwarrantyCreateJobTestAPIhelper {
	//

	private String token;
	private CreateJobPOJO createJobPOJO;
	private String job_Number;
	private APIHelper helper;

	@BeforeClass(description = "intializing  the baseURI, creating the testData for api testing") // before will be
																									// called before
																									// every@Test
	public void setup() {
		helper = new APIHelper();
		createJobPOJO = TestUtil.getCreateJobData();
		token = TestUtil.generateToken();
	}

	@Test(description = "verify if login API request is working or not", groups = { "sanity", "smoke", "e2e", "api",
			"regression" }, priority = 1)
	public void verifyLoginAPI() {

		token = helper
				.makeAPIRequest("v1/login", Verb.POST, new LoginPOJO("iamfd", "password"),
						new Header("content-type", "application/json"))
				.then()
				.and()
				.assertThat()
				.statusCode(200)
				.and()
				.assertThat()
				.body(Matchers.containsString("Success")).and().extract().jsonPath().getString("data.token");
		System.out.println("-------------" + token);
	}

	@Test(description = "verify if create job API request is working or not", groups = { "sanity", "smoke", "e2e",
			"api", "regression" }, priority = 2)
	public void createJobAPITest() {

		// Create the testData / request body dynamically

		// Multiple Headers to the request: List of Header where each index is a
		// reference variables which will store the Header object address
		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		myHeaderList.add(new Header("Authorization", token));

		job_Number =	helper
		.makeAPIRequest("/v1/job/create", Verb.POST, createJobPOJO,
				new Header("content-type", "application/json"),new Header("Authorization", token))
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body(Matchers.containsString("Job created successfully.")).extract().jsonPath().getString("data.id");
	}

}
