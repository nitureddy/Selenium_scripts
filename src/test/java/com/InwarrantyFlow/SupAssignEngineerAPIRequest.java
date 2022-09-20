package com.InwarrantyFlow;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import com.POJOAlreadyCreatedByMahesh.SupAssignEngPOJO;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SupAssignEngineerAPIRequest {

	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";
		
		Response response = given().when().log().all().header(new Header("Content-Type", "application/json")).and().header(new Header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiZmlyc3RfbmFtZSI6IkpvaG4iLCJsYXN0X25hbWUiOiJDZW5hIiwibG9naW5faWQiOiJpYW1zdXAiLCJtb2JpbGVfbnVtYmVyIjoiOTk4ODc3ODg5OSIsImVtYWlsX2lkIjoiam9obkBnbWFpbC5jb20iLCJwYXNzd29yZCI6IjVmNGRjYzNiNWFhNzY1ZDYxZDgzMjdkZWI4ODJjZjk5IiwicmVzZXRfcGFzc3dvcmRfZGF0ZSI6bnVsbCwibG9ja19zdGF0dXMiOjAsImlzX2FjdGl2ZSI6MSwibXN0X3JvbGVfaWQiOjIsIm1zdF9zZXJ2aWNlX2xvY2F0aW9uX2lkIjoxLCJjcmVhdGVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwibW9kaWZpZWRfYXQiOiIyMDIxLTEyLTIwVDA3OjQyOjAwLjAwMFoiLCJyb2xlX25hbWUiOiJTdXBlcnZpc29yIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE2NTg3MjA4ODZ9.qSfPNDynap2F_saW5czc2hv6TS0kTTtO7ZiE4ClfMcA"))
		.and().body(new SupAssignEngPOJO(7999, 2).toJson()).and().post("/v1/engineer/assign");
		
		JsonPath jp = new JsonPath(response.asString());
		System.out.println(jp.getString("message"));
		
		response.then().log().all().assertThat().statusCode(200).assertThat().body("message", equalTo("Engineer assigned successfully"));

		
	}

}