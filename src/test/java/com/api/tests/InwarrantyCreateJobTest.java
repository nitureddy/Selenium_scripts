package com.api.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.POJOAlreadyCreatedByMahesh.EngJobRepair;
import com.POJOAlreadyCreatedByMahesh.Problems;
import com.POJOAlreadyCreatedByMahesh.QCPassFlow;
import com.POJOAlreadyCreatedByMahesh.SupAssignEngPOJO;
import com.pojo.CreateJobPOJO;

import com.pojo.LoginPOJO;
import com.utils.TestUtil;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.ITestContext;

public class InwarrantyCreateJobTest {
	//

	private String fdtoken;
	private String suptoken;
	private String engtoken;
	private String qctoken;
	private CreateJobPOJO createJobPOJO;
//	private String job_Number;
	private int job_id;
	
	@BeforeClass(description = "intializing  the baseURI, creating the testData for api testing") // before will be
																									// called before
																									// every@Test
	public void setup() {
		baseURI = "http://139.59.91.96:9000";
		createJobPOJO = TestUtil.getCreateJobDataWithFaker();
		//token = TestUtil.generateToken();
	}

	@Test(description = "verify if login API request for FD is working or not", groups = { "sanity", "smoke", "e2e", "api",
			"regression" }, priority = 1)
	public void verifyLoginAPI() {

		fdtoken = given().when().header(new Header("content-type", "application/json")).and()
				.body(new LoginPOJO("iamfd", "password").toJson()).and().post("v1/login").then().log().all().and()
				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
				.extract().jsonPath().getString("data.token");
		System.out.println("--------------------------- FD Token ----------------");
		System.out.println(fdtoken);
		System.out.println("------------------------------------------------------");
	}

	@Test(description = "verify if create job API request is working or not", groups = { "sanity", "smoke", "e2e",
			"api", "regression" }, priority = 2)
	public void createJobAPITest() {

		// Create the testData / request body dynamically

		// Multiple Headers to the request: List of Header where each index is a
		// reference variables which will store the Header object address
		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		myHeaderList.add(new Header("Authorization", fdtoken));
		job_id = given().when().headers(new Headers(myHeaderList)).and().body(createJobPOJO.toJson()).and()
				.post("/v1/job/create").then().log().all().assertThat().statusCode(200).and()
				.body(Matchers.containsString("Job created successfully.")).extract().jsonPath().getInt("data.id");		
		
		System.out.println("Job created successfully.Job id =======> "+job_id);
		System.out.println("---------------------------------------------------------------");
		
	}
	
	@Test(description = "verify if login API request for Supervisor is working or not", groups = { "sanity", "smoke", "e2e", "api",
			"regression" }, priority = 3)
	public void verifySUPLoginAPI() {
		
			suptoken = given().when().header(new Header("content-type", "application/json")).and()
					.body(new LoginPOJO("iamsup", "password").toJson()).and().post("v1/login").then().log().all().and()
					.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
					.extract().jsonPath().getString("data.token");
			System.out.println("----------------- SUP Token --------------------------");
			System.out.println(suptoken);
			System.out.println("------------------------------------------------------");
			
		}
	
	@Test(description = "verify if API request for Assign job to engineer is working or not", groups = { "sanity", "smoke", "e2e", "api",
	"regression" }, priority = 4)
	public void SupAssignJobEngineerAPI() {
	
		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		myHeaderList.add(new Header("Authorization", suptoken));
		given().when().headers(new Headers(myHeaderList))
		.and().body(new SupAssignEngPOJO(job_id, 2).toJson())
		.and().post("/v1/engineer/assign").then().log().all().assertThat().statusCode(200).and()
		.body(Matchers.containsString("Engineer assigned successfully"));
	}
	
	@Test(description = "verify if login API request for Engineer is working or not", groups = { "sanity", "smoke", "e2e", "api",
		"regression" }, priority = 5)
	public void verifyENGLoginAPI() {
		
			engtoken = given().when().header(new Header("content-type", "application/json"))
					.and().body(new LoginPOJO("iameng", "password").toJson()).and().post("v1/login").then().log().all().and()
					.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
					.extract().jsonPath().getString("data.token");
			System.out.println("---------------------------- Eng Token ------------------------");
			System.out.println(engtoken);
			System.out.println("---------------------------------------------------------------");
		}
	
	@Test(description = "verify if API request for Begin Job repair is working or not", groups = { "sanity", "smoke", "e2e", "api",
	"regression" }, priority = 6)
	public void EngineerJObRepairAPI() {
		
		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		myHeaderList.add(new Header("Authorization", engtoken));

		Problems[] p = new Problems[1];
		p[0] = new Problems(1, "Complete");
		
		given().when().headers(new Headers(myHeaderList))
		.and().body(new EngJobRepair(job_id, p).toJson()).post("/v1/engineer/repaircomplete")
		.then().log().all().assertThat().statusCode(200).and().body(Matchers.containsString("Repair successful"));
	}
		
	@Test(description = "verify if login API request for QC is working or not", groups = { "sanity", "smoke", "e2e", "api",
	"regression" }, priority = 7)
	public void verifyQCLoginAPI() {
	
		qctoken = given().when().header(new Header("content-type", "application/json")).and()
				.body(new LoginPOJO("iamqc", "password").toJson()).and().post("v1/login").then().log().all().and()
				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
				.extract().jsonPath().getString("data.token");
		System.out.println("------------- QC Token ---------");
		System.out.println(qctoken);
		System.out.println("----------------------");		
	}
	
	@Test(description = "verify if API request for Complete QC is working or not", groups = { "sanity", "smoke", "e2e", "api",
	"regression" }, priority = 8)
	public void CompleteQCAPI() {
		
		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		myHeaderList.add(new Header("Authorization", qctoken));
		given().when().headers(new Headers(myHeaderList))
		.and().body(new QCPassFlow(job_id).toJson()).and().post("/v1/qc")
		.then().log().all().assertThat().statusCode(200)
		.and().body(Matchers.containsString("QC completed successfully"));

	}
}
