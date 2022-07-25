package com.InwarrantyFlow;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;



import com.POJOAlreadyCreatedByMahesh.SupLoginPOJO;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SupLoginAPIRequest {

	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";
		
		Response response = given().when().log().all().header(new Header("Content-Type", "application/json")).and().body(new SupLoginPOJO("iamsup", "password").toJson())
		.and().post("/v1/login");
		
		JsonPath jsonpath = new JsonPath(response.asString());
		String supToken = jsonpath.getString("data.token");
		System.out.println(supToken);
		
		response.then().log().all().assertThat().statusCode(200).body("message", equalTo("Success"));
	

	}

}
