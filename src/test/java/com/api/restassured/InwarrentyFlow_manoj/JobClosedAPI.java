package com.api.restassured.InwarrentyFlow_manoj;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.POJOAlreadyCreatedByMahesh.*;
import com.pojo.CreateJobPOJO;
import com.utils.TestUtil;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class JobClosedAPI {


	@BeforeMethod(description = "intializing  the baseURI, creating the testData for api testing") // before will be
																									// called before
																									// every@Test
	public void setup() {
		baseURI = "http://139.59.91.96:9000";
	}
	
	@Test(description = "verify if API request for job closed successfully is working or not", groups = { "sanity", "smoke", "e2e", "api",
	"regression" }, priority = 1)
	public void JOBClosedAPI(ITestContext ctx) {
		
		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		Object d = ctx.getAttribute("FDToken");
		Object j = ctx.getAttribute("JobID");
		System.out.println("--------------"+j);
		myHeaderList.add(new Header("Authorization",(String) d));
		
		given().when().headers(new Headers(myHeaderList))
		.and().body(new JOBSearchPOJO("JOB_"+j).toJson()).and().post("/v1/job/search")
		.then().log().all().assertThat().statusCode(200)
		.and().body(Matchers.containsString("Job Closed Successfully"));

	}	
	
}
