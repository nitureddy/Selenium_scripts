package com.InwarrantyFlow;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


import com.InwarrantyResponsePOJO.UserDetailsPOJO;
import com.InwarrantyResponsePOJO.Data;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FDUserDetailsAPIRequest {

	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";
		
		Response response = given().when().log().all().header(new Header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NCwiZmlyc3RfbmFtZSI6ImZkIiwibGFzdF9uYW1lIjoiZmQiLCJsb2dpbl9pZCI6ImlhbWZkIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo1LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiRnJvbnREZXNrIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE2NTg2NzQ0OTV9.1Dv8JVL1s7pUSZKyx7-X5F34Us_efXd0phn5-T5pLhc"))
		.get("/v1/userdetails");
		
		JsonPath jsonPath = new JsonPath(response.asPrettyString());
		UserDetailsPOJO user = new UserDetailsPOJO(jsonPath.getString("message"),
				new Data(jsonPath.getInt("data.id"), jsonPath.getString("data.first_name"),
						jsonPath.getString("data.last_name"), jsonPath.getString("data.login_id"),
						jsonPath.getString("data.mobile_number"), jsonPath.getString("data.email_id"), jsonPath.getString("data.password"), 
						jsonPath.getString("data.reset_password_date"), jsonPath.getString("data.lock_status"), 
						jsonPath.getString("data.is_active"), jsonPath.getString("data.mst_role_id"), 
						jsonPath.getString("data.mst_service_location_id"), jsonPath.getString("data.created_at"), 
						jsonPath.getString("data.modified_at"), jsonPath.getString("data.role_name"), 
						jsonPath.getString("data.service_location")));
		
		response.then().log().all().assertThat().statusCode(200).and().assertThat().body("message", equalTo("Success"));
		System.out.println("Test Complete");
		System.out.println(user);

	}

}
