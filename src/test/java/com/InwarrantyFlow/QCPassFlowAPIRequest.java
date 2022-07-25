package com.InwarrantyFlow;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

import com.POJOAlreadyCreatedByMahesh.QCLoginPOJO;
import com.POJOAlreadyCreatedByMahesh.QCPassFlow;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class QCPassFlowAPIRequest {

	public static void main(String[] args) {
		
		baseURI = "http://139.59.91.96:9000";
		
		Response response = given().when().log().all().header(new Header("Content-Type", "application/json")).and().header(new Header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MywiZmlyc3RfbmFtZSI6InFjIiwibGFzdF9uYW1lIjoicWMiLCJsb2dpbl9pZCI6ImlhbXFjIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo0LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiUUMiLCJzZXJ2aWNlX2xvY2F0aW9uIjoiU2VydmljZSBDZW50ZXIgQSIsImlhdCI6MTY1ODczMzEwN30.aTqtn6RgQ4fp3Xsqa1hhTt1HZotMIysXpg4jTD45OJo"))
				.and().body(new QCPassFlow(7988).toJson()).and().post("/v1/qc");
		
		JsonPath jp = new JsonPath(response.asString());
		String message = jp.getString("message");
		System.out.println(message);
		response.then().log().all().assertThat().statusCode(200).and().body(Matchers.containsString("Repair successful"));

	}

}
