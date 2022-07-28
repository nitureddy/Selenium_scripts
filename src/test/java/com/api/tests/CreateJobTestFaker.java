package com.api.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pojo.CreateJobPOJO;
import com.utils.TestUtil;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class CreateJobTestFaker {

	private String token;
	private CreateJobPOJO createJobPOJO;
	private String job_Number;

	@BeforeMethod(description = "intializing  the baseURI, creating the testData for api testing") // before will be
																									// called before
																									// every@Test
	public void setup() {
		baseURI = "http://139.59.91.96:9000";
		createJobPOJO = TestUtil.getCreateJobDataWithFaker();
		token = TestUtil.generateToken();
	}

	@Test(description = "verify if create job API request is working or not", groups = { "sanity", "smoke", "e2e",
			"api", "regression" }, priority = 2)
	public void createJobAPITest() {
		System.out.println(createJobPOJO.toJson());

	}

}
