package com.InwarrantyFlow;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import com.POJOAlreadyCreatedByMahesh.EngJobRepair;
import com.POJOAlreadyCreatedByMahesh.Problems;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class EngJobRepairAPIRequest {

	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";
		
		Problems[] p = new Problems[2];
		p[0] = new Problems(1, "crash issue");
		p[1] = new Problems(4, "Sync Fixed");

		
		Response response = given().when().log().all().header(new Header("Content-Type", "application/json")).and().header(new Header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MiwiZmlyc3RfbmFtZSI6Ik1hcmsiLCJsYXN0X25hbWUiOiJ6dWsiLCJsb2dpbl9pZCI6ImlhbWVuZyIsIm1vYmlsZV9udW1iZXIiOiI4ODk5Nzc2NjU1IiwiZW1haWxfaWQiOiJtYXJrQGdtYWlsLmNvbSIsInBhc3N3b3JkIjoiNWY0ZGNjM2I1YWE3NjVkNjFkODMyN2RlYjg4MmNmOTkiLCJyZXNldF9wYXNzd29yZF9kYXRlIjpudWxsLCJsb2NrX3N0YXR1cyI6MCwiaXNfYWN0aXZlIjoxLCJtc3Rfcm9sZV9pZCI6MSwibXN0X3NlcnZpY2VfbG9jYXRpb25faWQiOjEsImNyZWF0ZWRfYXQiOiIyMDIxLTExLTAzVDA4OjA2OjIzLjAwMFoiLCJtb2RpZmllZF9hdCI6IjIwMjEtMTItMjBUMDc6NDI6MDAuMDAwWiIsInJvbGVfbmFtZSI6IkVuZ2luZWVyIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE2NTg3NDM4MDJ9.9OkkIP3GaInK5EXIHwhUSiXgWqPDjwn6KjIlkZ5uRrU"))
		.and().body(new EngJobRepair(7999, p).toJson()).post("/v1/engineer/repaircomplete");
		
		JsonPath jp = new JsonPath(response.asString());
		jp.getString("message");
		
		response.then().log().all().assertThat().statusCode(200).and().body(Matchers.containsString("Repair successful"));
		
		

	}

}
