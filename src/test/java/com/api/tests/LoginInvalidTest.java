package com.api.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pojo.LoginPOJO;
import com.utils.TestUtil;

import io.restassured.http.Header;

public class LoginInvalidTest extends TestBase {

	private String token;
//	HashMap<String, String> tokenMap;

	@BeforeClass(description = "intializing  the baseURI") // before will be
	// called before
	// every@Test

	public void setup() {
		baseURI = "http://139.59.91.96:9000";
		tokenMap = new HashMap<String, String>();

	}

	@Test(description = "verify if login API request is working or not", groups = { "sanity", "smoke", "e2e", "api",
			"regression" }, priority = 1, dataProviderClass = com.dataproviders.LoginDataProvider.class, dataProvider = "loginDP")
	public void verifyLoginAPI(String userRole, String x, String y, ITestContext ctx) {

		token = given().when().header(new Header("content-type", "application/json")).and()
				.body(new LoginPOJO(x, y).toJson()).and().post("v1/login").then().log().all().and().assertThat()
				.statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and().extract().jsonPath()
				.getString("data.token");
		System.out.println("-------------" + token);
		System.out.println("Inside Login Test" + token);
		System.out.println(userRole);
		tokenMap.put(userRole, token);
		ctx.setAttribute("FDToken", token);

	}

	@Test(priority = 2)
	public void getToken() {
		System.out.println(tokenMap.get("SUP"));
	}
}
