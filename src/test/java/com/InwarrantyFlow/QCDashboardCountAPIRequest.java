package com.InwarrantyFlow;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

import com.InwarrantyResponsePOJO.DashboardCount;
import com.InwarrantyResponsePOJO.DashboardData;
import com.POJOAlreadyCreatedByMahesh.QCLoginPOJO;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class QCDashboardCountAPIRequest {

	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";
		
		Response response = given().when().log().all().header(new Header("Content-Type", "application/json")).and().header(new Header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MywiZmlyc3RfbmFtZSI6InFjIiwibGFzdF9uYW1lIjoicWMiLCJsb2dpbl9pZCI6ImlhbXFjIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo0LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiUUMiLCJzZXJ2aWNlX2xvY2F0aW9uIjoiU2VydmljZSBDZW50ZXIgQSIsImlhdCI6MTY1ODczMjIxN30.1oxAlVHkqpX01d6FT0KMkbAHgJ4DZlUcedqJLyCsiKA"))
				.and().get("/v1/dashboard/count");

		JsonPath jsonPath = new JsonPath(response.asPrettyString());
		String label1 = jsonPath.getString("data[0].label");
		String key = jsonPath.getString("data[0].key");
		int count = jsonPath.getInt("data[0].count");
		DashboardData dd[] = new DashboardData[3];
		dd[0] = new DashboardData(label1, key, count);
		dd[1] = new DashboardData(jsonPath.getString("data[1].label"), jsonPath.getString("data[1].key"), jsonPath.getInt("data[1].count"));
		dd[2] = new DashboardData(jsonPath.getString("data[2].label"), jsonPath.getString("data[2].key"), jsonPath.getInt("data[2].count"));
		
		DashboardCount dbCount = new DashboardCount(jsonPath.getString("message"), dd);
		System.out.println(dbCount);
		System.out.println(dd[0].getCount());
		System.out.println("Pending for QC :: "+dd[0].getCount());
		System.out.println("QC Completed :: "+dd[1].getCount());
		System.out.println("QC Rejected :: "+dd[2].getCount());
		
		response.then().log().all().assertThat().statusCode(200).body(Matchers.containsString("Success"));
		
		

	}

}
