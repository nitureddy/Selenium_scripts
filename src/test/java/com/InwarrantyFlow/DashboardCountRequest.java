package com.InwarrantyFlow;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import com.InwarrantyResponsePOJO.DashboardData;

import com.InwarrantyResponsePOJO.DashboardCount;
import com.InwarrantyResponsePOJO.DashboardData;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DashboardCountRequest {

	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";
		
		Response response = given().when().log().all().header(new Header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NCwiZmlyc3RfbmFtZSI6ImZkIiwibGFzdF9uYW1lIjoiZmQiLCJsb2dpbl9pZCI6ImlhbWZkIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo1LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiRnJvbnREZXNrIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE2NTg2NzQ0OTV9.1Dv8JVL1s7pUSZKyx7-X5F34Us_efXd0phn5-T5pLhc"))
		.get("v1/dashboard/count");
		
		JsonPath jsonPath = new JsonPath(response.asPrettyString());
		String label1 = jsonPath.getString("data[0].label");
		String key = jsonPath.getString("data[0].key");
		int count = jsonPath.getInt("data[0].count");
		
		DashboardData dd[] = new DashboardData[3];
		dd[0] = new DashboardData(label1, key, count);
		dd[1] = new DashboardData(jsonPath.getString("data[1].label"), jsonPath.getString("data[1].key"), jsonPath.getInt("data[1].count"));
		dd[2] = new DashboardData(jsonPath.getString("data[2].label"), jsonPath.getString("data[2].key"), jsonPath.getInt("data[2].count"));
		
		DashboardCount dbCount = new DashboardCount(jsonPath.getString("message"), dd);
		
		System.out.println(dbCount.getData());
		System.out.println("Pending for delivery :: "+dd[0].getCount());
		System.out.println("Created today :: "+dd[1].getCount());
		System.out.println("Pending for FST assignment :: "+dd[2].getCount());
		
		response.then().log().all().assertThat().statusCode(200).body(Matchers.containsString("Success"));

	}

}
