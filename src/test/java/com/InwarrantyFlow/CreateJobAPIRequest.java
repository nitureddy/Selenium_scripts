package com.InwarrantyFlow;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import com.InwarrantyResponsePOJO.CreateJobResponse;
import com.InwarrantyResponsePOJO.CreateJobResponseData;
import com.pojo.CreateJobPOJO;
import com.pojo.CustomerAddressPOJO;
import com.pojo.CustomerPOJO;
import com.pojo.CustomerProductPOJO;
import com.pojo.ProblemPOJO;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateJobAPIRequest {

	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";
		CustomerAddressPOJO customerAddress = new CustomerAddressPOJO("101", "ABC", "MG Road", "inorbit", "abc",
				"400104", "india", "Maharashtra");
		CustomerPOJO customer = new CustomerPOJO("amit", "nair", "4354654634", "4354654634", "amit@gmail.com", "");
		CustomerProductPOJO customerProductPOJO = new CustomerProductPOJO("2022-05-03T18:30:00.000Z", "78956433221389",
				"78956433221389", "78956433221389", "2022-05-03T18:30:00.000Z", 1, 1);
		ProblemPOJO[] problems = new ProblemPOJO[2];
		problems[0] = new ProblemPOJO(1, " battery low");
		problems[1] = new ProblemPOJO(2, " display not working");
		CreateJobPOJO jobPojo = new CreateJobPOJO(0, 2, 1, 1, customer, customerAddress, customerProductPOJO, problems);
		
		Response response = given().when().log().all().header(new Header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NCwiZmlyc3RfbmFtZSI6ImZkIiwibGFzdF9uYW1lIjoiZmQiLCJsb2dpbl9pZCI6ImlhbWZkIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo1LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiRnJvbnREZXNrIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE2NTg2NzQ0OTV9.1Dv8JVL1s7pUSZKyx7-X5F34Us_efXd0phn5-T5pLhc"))
		.and().header(new Header("Content-type", "application/json")).and().body(jobPojo.toJson()).post("/v1/job/create");
		
		
		JsonPath jsonPath = new JsonPath(response.asString());
		System.out.println(jsonPath.getInt("data.id"));
		CreateJobResponse cj = new CreateJobResponse(jsonPath.getString("message"), new CreateJobResponseData(jsonPath.getInt("data.id"), 
				jsonPath.getInt("data.mst_service_location_id"), jsonPath.getInt("data.mst_warrenty_status_id"), jsonPath.getInt("data.mst_oem_id"), jsonPath.getInt("data.tr_customer_id"), jsonPath.getString("data.tr_customer_product_id"), jsonPath.getString("data.job_number")));
		
		System.out.println(cj);
		
		response.then().log().all().assertThat().statusCode(200); //.body(Matchers.contains("Job created successfully"));



		


		

	}

}
