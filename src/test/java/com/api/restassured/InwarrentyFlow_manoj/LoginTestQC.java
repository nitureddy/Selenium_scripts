package com.api.restassured.InwarrentyFlow_manoj;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pojo.LoginPOJO;
import com.utils.TestUtil;

import io.restassured.http.Header;

public class LoginTestQC {

	private String token;

	@BeforeMethod(description = "intializing  the baseURI") // before will be
	// called before
	// every@Test
	public void setup() {
		baseURI = "http://139.59.91.96:9000";
	}

	@Test(description = "verify if login API request for QC is working or not", groups = { "sanity", "smoke", "e2e", "api",
			"regression" }, priority = 1)
	public void verifyLoginAPI(ITestContext ctx) {

		token = given().when().header(new Header("content-type", "application/json")).and()
				.body(new LoginPOJO("iamqc", "password").toJson()).and().post("v1/login").then().log().all().and()
				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
				.extract().jsonPath().getString("data.token");
		System.out.println("----------------- QC Token --------------------------");
		System.out.println(token);
		System.out.println("------------------------------------------------------");

		ctx.setAttribute("QCToken", token);

	}
	
}
