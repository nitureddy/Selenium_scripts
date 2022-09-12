package com.api.requests;

import static io.restassured.RestAssured.*; //static import

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;

import com.pojo.Data;
import com.pojo.JobSearchPOJO;
import com.pojo.LoginPOJO;
import com.pojo.UserDetailsPOJO;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
 * static variable/function {block} classes import!!
 * 
 * 
 */

public class UserDetailsRequest {
	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";

		List<Header> myHeaderList = new ArrayList<Header>();
		myHeaderList.add(new Header("content-type", "application/json"));
		myHeaderList.add(new Header("Authorization", fdToken));
		String mst_action_status = given().when().headers(new Headers(myHeaderList)).and()
				.body(new JobSearchPOJO(job_Number).toJson()).and().post("/v1/search").then().assertThat().log().all().extract()
				.jsonPath().get("data[0].mst_action_status");
		Assert.assertEquals(mst_action_status, "Pending For Assignment");
	
	}
}
