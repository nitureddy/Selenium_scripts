package com.api.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.*;

import com.POJOAlreadyCreatedByMahesh.*;
import com.pojo.CreateJobPOJO;
import com.pojo.CustomerAddressPOJO;
import com.pojo.CustomerPOJO;
import com.pojo.CustomerProductPOJO;
import com.pojo.ProblemPOJO;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginAPITest {
	
	private String token;
	@BeforeTest(description = "initialising the Base URI")
	public void setup() {
		baseURI = "http://139.59.91.96:9000";
	}
	@Test(description = "Verify if Login API working or not", groups = {"sanity","smoke","api","regression","e2e"}, priority = 1)
	public void verifyLoginAPI() {

		token = given().when().header(new Header("content-type", "application/json"))
		.and().body(new FDLoginPOJO("iamfd", "password").toJson()).and().post("/v1/login").then().log().all().and()
		.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
		.extract().jsonPath().getString("data.token");

	System.out.println("Token :> "+token);	
	}
	
	@Test(description = "Verify if Create Job API working or not", groups = {"sanity","smoke","api","regression","e2e"}, priority = 2)
	public void createjobAPITest() {

		CustomerAddressPOJO customerAddress = new CustomerAddressPOJO("101", "ABC", "MG Road", "inorbit", "abc",
				"400104", "india", "Maharashtra");
		CustomerPOJO customer = new CustomerPOJO("momo", "nono", "4354654634", "4354654634", "amit@gmail.com", "");
		CustomerProductPOJO customerProductPOJO = new CustomerProductPOJO("2022-07-27T18:30:00.000Z", "78956433221389",
				"78956433221301", "78956433221301", "2022-07-27T18:30:00.000Z", 1, 1);
		ProblemPOJO[] problems = new ProblemPOJO[1];
		problems[0] = new ProblemPOJO(1, " battery low");
		CreateJobPOJO jobPojo = new CreateJobPOJO(0, 2, 1, 1, customer, customerAddress, customerProductPOJO, problems);
		
		String job_number = given().when().header(new Header("Authorization",token))
		.and().header(new Header("Content-type", "application/json")).and().body(jobPojo.toJson()).post("/v1/job/create").then().log().all()
		.and().assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Job created successfully"))
		.and().extract().jsonPath().getString("data.job_number");;
		
		System.out.println("Job number >>> "+job_number);
//		
//		JsonPath jsonPath = new JsonPath(response.asString());
//		System.out.println(jsonPath.getInt("data.id"));
//		CreateJobResponse cj = new CreateJobResponse(jsonPath.getString("message"), new CreateJobResponseData(jsonPath.getInt("data.id"), 
//				jsonPath.getInt("data.mst_service_location_id"), jsonPath.getInt("data.mst_warrenty_status_id"), jsonPath.getInt("data.mst_oem_id"), jsonPath.getInt("data.tr_customer_id"), jsonPath.getString("data.tr_customer_product_id"), jsonPath.getString("data.job_number")));
//		
//		System.out.println(cj);
		


	}
	

}
