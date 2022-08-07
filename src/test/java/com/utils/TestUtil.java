package com.utils;

import static io.restassured.RestAssured.given;

import java.util.Locale;

import org.hamcrest.Matchers;
import org.testng.ITestContext;

import com.github.javafaker.Faker;
import com.pojo.CreateJobPOJO;
import com.pojo.CustomerAddressPOJO;
import com.pojo.CustomerPOJO;
import com.pojo.CustomerProductPOJO;
import com.pojo.LoginPOJO;
import com.pojo.ProblemPOJO;

import io.restassured.http.Header;

public class TestUtil {

	public static CreateJobPOJO getCreateJobData() {
		// String imei = createIMEINumber();
		CustomerPOJO customerInfoPOJO = new CustomerPOJO("vaibhav", "Kalshetti", "9705593183", "970555445",
				"vaibhav@gmail.com", "");
		CustomerAddressPOJO customerAddressPOJO = new CustomerAddressPOJO("101", "abc apt", "street name1",
				"near ayyapa temple", "kukatpally", "500072", "India", "Andhra Pradesh");
		CustomerProductPOJO customerProductPOJO = new CustomerProductPOJO("2022-04-05T18:30:00.000Z", "62344567123411",
				"62344567123411", "62344567123411", "2022-04-05T18:30:00.000Z", 1, 2);
		ProblemPOJO[] problems = new ProblemPOJO[3];
		problems[0] = new ProblemPOJO(1, "battery drains quickly");
		problems[1] = new ProblemPOJO(4, "camera not working");
		problems[2] = new ProblemPOJO(3, "app crashes");

		CreateJobPOJO createJobPOJO = new CreateJobPOJO(0, 2, 1, 1, customerInfoPOJO, customerAddressPOJO,
				customerProductPOJO, problems);
		System.out.println(createJobPOJO.toJson());
		return createJobPOJO;
	}

	public static CreateJobPOJO getCreateJobDataWithFaker() {
		// String imei = createIMEINumber();
		Faker faker = new Faker(Locale.ENGLISH);
		String imei = faker.numerify("##############");
		CustomerPOJO customerInfoPOJO = new CustomerPOJO(faker.address().firstName(), faker.address().lastName(),
				faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), faker.internet().emailAddress(), "");
		CustomerAddressPOJO customerAddressPOJO = new CustomerAddressPOJO("101", "abc apt", "street name1",
				"near ayyapa temple", "kukatpally", "500072", "India", "Andhra Pradesh");
		CustomerProductPOJO customerProductPOJO = new CustomerProductPOJO("2022-04-05T18:30:00.000Z", imei, imei, imei,
				"2022-04-05T18:30:00.000Z", 1, 2);
		ProblemPOJO[] problems = new ProblemPOJO[3];
		problems[0] = new ProblemPOJO(1, "battery drains quickly");
		problems[1] = new ProblemPOJO(4, "camera not working");
		problems[2] = new ProblemPOJO(3, "app crashes");

		CreateJobPOJO createJobPOJO = new CreateJobPOJO(0, 2, 1, 1, customerInfoPOJO, customerAddressPOJO,
				customerProductPOJO, problems);
		System.out.println(createJobPOJO.toJson());
		return createJobPOJO;
	}

	public String createIMEINumber() {
		// Generate a random 14 digit number using Java
		return null;
	}

	public static String generateToken() {
		String token = given().when().header(new Header("content-type", "application/json")).and()
				.body(new LoginPOJO("iamfd", "password").toJson()).and().post("v1/login").then().log().all().and()
				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
				.extract().jsonPath().getString("data.token");
		System.out.println("I am token from generateToken ---- >>> " + token);
		//ctx.setAttribute("FDToken", token);
		return token;

	}
}
