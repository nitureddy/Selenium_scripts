package com.api.tests;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dao.CustomerDAO;
import com.dao.CustomerPOJO;
import com.pojo.CreateJobPOJO;
import com.pojo.CustomerAddressPOJO;
import com.pojo.CustomerProductPOJO;
import com.pojo.LoginPOJO;
import com.pojo.ProblemPOJO;
import com.utils.TestUtil;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class InwarrantyCreateJobTest {
	//

	private String token;
	private CreateJobPOJO createJobPOJO;
	private String job_Number;
	private com.pojo.CustomerPOJO customerInfoPassed;
	private int customerId;

	@BeforeTest(description = "intializing  the baseURI, creating the testData for api testing", alwaysRun = true) // before will be																						// called befo																							// every@Test
																									// called before
																									// every@Test
	public void setup() {
		baseURI = "http://139.59.91.96:9000";
		createJobPOJO = TestUtil.getCreateJobDataWithFaker();
		token = TestUtil.generateToken();
		customerInfoPassed = createJobPOJO.getCustomer();
	}

	@Test(description = "verify if login API request is working or not", groups = { "sanity", "smoke", "e2e", "api",
			"regression" }, priority = 1)
	public void verifyLoginAPI() {

		token = given().when().header(new Header("content-type", "application/json")).and()
				.body(new LoginPOJO("iamfd", "password").toJson()).and().post("v1/login").then().log().all().and()
				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
				.extract().jsonPath().getString("data.token");
		System.out.println("-------------" + token);
	}

	@Test(description = "verify if create job API request is working or not", groups = { "sanity", "smoke", "e2e",
			"api", "regression" }, priority = 2)
	public void createJobAPITest() {
		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		myHeaderList.add(new Header("Authorization", token));

		Response reponse = given().when().headers(new Headers(myHeaderList)).and().body(createJobPOJO.toJson()).and()
				.post("/v1/job/create");

		job_Number = reponse.then().log().all().assertThat().statusCode(200).and()
				.body(Matchers.containsString("Job created successfully.")).extract().jsonPath().getString("data.id");

		customerId = reponse.then().extract().jsonPath().getInt("data.tr_customer_id");

	}

	// DB Verification
	@Test(description = "Verify Customer Entry in DB after job creation", dependsOnMethods = "createJobAPITest")
	public void verifyCustomerInfo() {

		CustomerDAO customer = new CustomerDAO();
		CustomerPOJO customerInformationRetrivedFromDB = customer.getCustomerInformationfFromDB(customerId);
		Assert.assertEquals(customerInfoPassed.getFirst_name(), customerInformationRetrivedFromDB.getFirst_name());
		Assert.assertEquals(customerInfoPassed.getLast_name(), customerInformationRetrivedFromDB.getLast_name());
		Assert.assertEquals(customerInfoPassed.getMobile_number(), customerInformationRetrivedFromDB.getMobile_number());

	}

}
