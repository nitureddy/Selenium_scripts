package com.InwarrantyFlow;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SelectJobID {

	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";
		
		Response response = given().when().log().all().header("Content-Type","text/plain").and().header(new Header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NCwiZmlyc3RfbmFtZSI6ImZkIiwibGFzdF9uYW1lIjoiZmQiLCJsb2dpbl9pZCI6ImlhbWZkIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo1LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiRnJvbnREZXNrIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE2NTg2ODQyMzJ9.TpEgKtIX-zKvVVCWTSGjoUguVjYA6mNsX55Z0ZG2kvY"))
		.and().post("/v1/job/details/job_7999");
		
		JsonPath jp = new JsonPath(response.asString());
		System.out.println("Current Job Status :: "+jp.getString("data.mst_action_status"));
		System.out.println("Problem Details:: "+jp.getString("data.problems[0].problem"));
		
		response.then().log().all().assertThat().statusCode(200).and().body(Matchers.containsString("Success"));

	}

}
