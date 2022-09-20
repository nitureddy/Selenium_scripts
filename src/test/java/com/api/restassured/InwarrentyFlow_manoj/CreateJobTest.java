package com.api.restassured.InwarrentyFlow_manoj;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pojo.CreateJobPOJO;
import com.utils.TestUtil;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class CreateJobTest {

	private String token;
	private CreateJobPOJO createJobPOJO;
	private int job_id;

	@BeforeMethod(description = "intializing  the baseURI, creating the testData for api testing") // before will be
																									// called before
																									// every@Test
	public void setup() {
		baseURI = "http://139.59.91.96:9000";
		createJobPOJO = TestUtil.getCreateJobDataWithFaker();
		//token = TestUtil.generateToken();
	}

	@Test(description = "verify if create job API request is working or not", groups = { "sanity", "smoke", "e2e",
			"api", "regression" }, priority = 1)
	public void createJobAPITest(ITestContext ctx) {

		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		Object d = ctx.getAttribute("FDToken");
		System.out.println("Inside Create Job Test"+(String) d);
		myHeaderList.add(new Header("Authorization", (String) d));

		job_id = given().when().headers(new Headers(myHeaderList)).and().body(createJobPOJO.toJson()).and()
				.post("/v1/job/create").then().log().all().assertThat().statusCode(200).and()
				.body(Matchers.containsString("Job created successfully."))
				.body("data.mst_service_location_id", Matchers.equalTo(1))
				.body("data.mst_platform_id", Matchers.equalTo(2))
				.body("data.mst_warrenty_status_id", Matchers.equalTo(1)).body("data.mst_oem_id", Matchers.equalTo(1))
				.body("data.tr_customer_id", Matchers.greaterThan(0))
				.body("data.tr_customer_product_id", Matchers.greaterThan(0)).extract().jsonPath().getInt("data.id");
		
		System.out.println("Job number : --->>>> "+job_id);
		
		ctx.setAttribute("JobID", job_id);
	}

}