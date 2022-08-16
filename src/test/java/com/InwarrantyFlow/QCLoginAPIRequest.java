package com.InwarrantyFlow;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

import com.POJOAlreadyCreatedByMahesh.EngLoginPOJO;
import com.POJOAlreadyCreatedByMahesh.QCLoginPOJO;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class QCLoginAPIRequest {

	public static void main(String[] args) {
			baseURI = "http://139.59.91.96:9000";
		
			Response response = given().when().log().all().header(new Header("Content-Type", "application/json")).and().header(new Header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MywiZmlyc3RfbmFtZSI6InFjIiwibGFzdF9uYW1lIjoicWMiLCJsb2dpbl9pZCI6ImlhbXFjIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo0LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiUUMiLCJzZXJ2aWNlX2xvY2F0aW9uIjoiU2VydmljZSBDZW50ZXIgQSIsImlhdCI6MTY1ODczMjIxN30.1oxAlVHkqpX01d6FT0KMkbAHgJ4DZlUcedqJLyCsiKA"))
					.and().body(new QCLoginPOJO("iamqc", "password")).and().post("/v1/login");
			
			JsonPath jsonpath = new JsonPath(response.asString());
			String message = jsonpath.getString("message");
			System.out.println(message);
			
			response.then().log().all().assertThat().statusCode(200).and().body(Matchers.containsString("Success"));
			System.out.println("QC Login successful");
		

	}

}
