package com.api.requests;

import static io.restassured.RestAssured.*; //static import

import org.hamcrest.Matchers;

import com.pojo.LoginPOJO;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
 * static variable/function {block} classes import!!
 * 
 * 
 */

public class LoginAPIRequestOptimized4POJO {
	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";
//RA 
		/*
		 * BDD Non technical and technical team both understand the testscript given
		 * when then
		 * 
		 * conjunctions
		 * 
		 * 
		 */
		Response response = given().when().header(new Header("content-type", "application/json")).and()
				.body(new LoginPOJO("iamfd", "password").toJson()).and().post("/v1/login");

		
		
		// Parsing in RA for JSON
		// JsonPath
		JsonPath jsonPath = new JsonPath(response.asPrettyString());
		String token = jsonPath.getString("data.token");
		
		
		System.out.println(token);
		System.out.println("---------------------------");
			response.then().log().all().and().assertThat().statusCode(200).and().assertThat()
					.body(Matchers.containsString("Success"));
	}
}
