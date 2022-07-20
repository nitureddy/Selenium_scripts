package com.api.requests;

import static io.restassured.RestAssured.*; //static import

import org.hamcrest.Matchers;

import com.pojo.Data;
import com.pojo.LoginPOJO;
import com.pojo.UserDetailsPOJO;

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

public class UserDetailsRequest {
	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";

		Response response = given().when().header(new Header("Authorization",
				"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NCwiZmlyc3RfbmFtZSI6ImZkIiwibGFzdF9uYW1lIjoiZmQiLCJsb2dpbl9pZCI6ImlhbWZkIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo1LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiRnJvbnREZXNrIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE2NTgzMzYwNTh9.R1wsBBNhWFFITnwo1OEDOd9ps34K3DspI9kUmjMXHB0"))
				.and().get("/v1/userdetails");

		JsonPath jsonPath = new JsonPath(response.asPrettyString());

		UserDetailsPOJO user = new UserDetailsPOJO(jsonPath.getString("message"),
				new Data(jsonPath.getInt("data.id"), jsonPath.getString("data.first_name"),
						jsonPath.getString("data.last_name"), jsonPath.getString("data.login_id"),
						jsonPath.getString("data.mobile_number"), "", "", "", "", "", "", "", "", "", "", ""));
		
	//	response.then().log().all().assertThat().statusCode(200).assertThat().body(Matchers.containsString("Success"));
		
		System.out.println(user);
	
	}
}
