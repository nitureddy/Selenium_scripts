package com.InwarrantyFlow;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.hamcrest.Matchers;

import com.POJOAlreadyCreatedByMahesh.FDLoginPOJO;
import com.pojo.LoginAPIFdPOJO;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FDLoginAPIRequest {

	public static void main(String[] args) {
		RestAssured.baseURI = "http://139.59.91.96:9000";
		
		Response response =   given().when().log().all().header(new Header("Content-Type", "application/json")).and()
		.body(new FDLoginPOJO("iamfd", "password").toJson()).and().post("/v1/login");
		
		JsonPath jsonPath = new JsonPath(response.asString());
		String FDToken = jsonPath.getString("data.token");
		
		System.out.println(FDToken);
		response.then().log().all().assertThat().statusCode(200).assertThat()
		.body("message", equalTo("Success"));
		System.out.println("FD Login successful");

	}

}
