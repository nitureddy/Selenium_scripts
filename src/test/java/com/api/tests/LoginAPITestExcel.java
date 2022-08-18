package com.api.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.*;

import com.POJOAlreadyCreatedByMahesh.*;
import com.pojo.CreateJobPOJO;
import com.pojo.CustomerAddressPOJO;
import com.pojo.CustomerPOJO;
import com.pojo.CustomerProductPOJO;
import com.pojo.ProblemPOJO;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginAPITestExcel {

	private String token;

	@BeforeTest(description = "initialising the Base URI")
	public void setup() {
		baseURI = "http://139.59.91.96:9000";
	}

	@Test(description = "Verify if Login API working or not",

			dataProviderClass = com.dataproviders.LoginDataProviderExcel.class, dataProvider = "loginDPExcel", groups =

			{ "sanity", "smoke", "api", "regression", "e2e" }, priority = 1)

	public void verifyLoginAPI(String x, String y) {
		token = given().when().header(new Header("content-type", "application/json")).and()
				.body(new FDLoginPOJO(x, y).toJson()).and().post("/v1/login").then().log().all().and().assertThat()
				.statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and().extract().jsonPath()
				.getString("data.token");

		System.out.println("Token :> " + token);
	}

}
