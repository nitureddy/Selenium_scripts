package com.InwarrantyFlow;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

import com.POJOAlreadyCreatedByMahesh.DeliverToCustomerFlow;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeliverToCustAPIRequest {

	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";
		Response response = given().when().log().all().header(new Header("Content-Type", "application/json")).and().header(new Header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NCwiZmlyc3RfbmFtZSI6ImZkIiwibGFzdF9uYW1lIjoiZmQiLCJsb2dpbl9pZCI6ImlhbWZkIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo1LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiRnJvbnREZXNrIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE2NTg3MzQ3ODB9.x-s9HBKtAt7_lvc1xS3JyYfe3devhYLESN-jen_a8zM"))
		.and().body(new DeliverToCustomerFlow(7988).toJson()).and().post("/v1/fd/delivertocustomer");
		
		JsonPath jsonpath = new JsonPath(response.asString());
		String message = jsonpath.getString("message");
		
		response.then().log().all().assertThat().statusCode(200).and().body(Matchers.containsString("Delivered to customer successfully"));

	}

}
