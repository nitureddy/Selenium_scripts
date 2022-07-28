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
import io.restassured.module.jsv.JsonSchemaValidator;

public class SchemaValidationTest {
	//

	private String token;
	private CreateJobPOJO createJobPOJO;
	private String job_Number;

	@BeforeClass(description = "intializing  the baseURI, creating the testData for api testing") // before will be
																									// called before
																									// every@Test
	public void setup() {
		baseURI = "http://139.59.91.96:9000";
		createJobPOJO = TestUtil.getCreateJobData();

	}

	@Test(description = "verify if login API request is working or not", groups = { "sanity", "smoke", "e2e", "api",
			"regression" }, priority = 1)
	public void verifyLoginAPI() {

		token = given().when().header(new Header("content-type", "application/json")).and()
				.body(new LoginPOJO("iamfd", "password").toJson()).and().post("v1/login").then().log().all().and()
				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("loginResponseSchema.json")).and()
	

				.extract().jsonPath().getString("data.token");
	}

}
