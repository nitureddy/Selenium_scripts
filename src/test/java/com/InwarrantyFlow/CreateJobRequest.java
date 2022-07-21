package com.InwarrantyFlow;

import static io.restassured.RestAssured.*;

import com.pojo.CreateJobPOJO;
import com.pojo.CustomerAddressPOJO;
import com.pojo.CustomerPOJO;
import com.pojo.CustomerProductPOJO;
import com.pojo.LoginPOJO;
import com.pojo.ProblemPOJO;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateJobRequest {

	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";
		String response = given().header(new Header("Content-type", "application/json"))
				.body(new LoginPOJO("iamfd", "password").toJson()).post("/v1/login").asString();
		JsonPath js = new JsonPath(response);
		String token = js.getString("data.token");
		System.out.println(token);
		System.out.println("executing the create job API");
		
		CustomerAddressPOJO customerAddress = new CustomerAddressPOJO("101", "ABC", "MG Road", "inorbit", "abc",
				"400104", "india", "Maharashtra");
		CustomerPOJO customer = new CustomerPOJO("amit", "nair", "4354654634", "4354654634", "amit@gmail.com", "");
		CustomerProductPOJO customerProductPOJO = new CustomerProductPOJO("2022-05-03T18:30:00.000Z", "78909878909894",
				"78909878909894", "78909878909894", "2022-05-03T18:30:00.000Z", 1, 1);
		ProblemPOJO[] problems = new ProblemPOJO[2];
		problems[0] = new ProblemPOJO(1, " battery low");
		problems[1] = new ProblemPOJO(2, " display not working");
		CreateJobPOJO jobPojo = new CreateJobPOJO(0, 2, 1, 1, customer, customerAddress, customerProductPOJO, problems);
		String s = given().header(new Header("Content-type", "application/json")).header(new Header("Authorization", token))
		.body(jobPojo.toJson()).post("/v1/job/create").asString();
		System.out.println("Response of Create Job Request");
		System.out.println(s);

	}

}
