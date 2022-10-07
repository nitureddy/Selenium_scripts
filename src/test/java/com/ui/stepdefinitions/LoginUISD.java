package com.ui.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import com.api.pojo.PhoenixLoginCredentialsPOJO;
import com.day2.Browser;
import com.ui.pages.FDDashboardPage;
import com.ui.pages.LoginPage;

/**
 * 
 * The {@code LoginAPISD} class the Step Definition for the LoginAPI.geature
 * 
 * <p>
 * If you want to add a StepDefinition please create them inside
 * src/test/java/com.stepdefinitions. Please attach the featuresfiles in the
 * src/test/resoures/features
 * </p>
 * 
 * @author Jatin
 * @tag UAT Test
 *
 */
public class LoginUISD {
	LoginPage loginPage;
	FDDashboardPage fdDashboardPage;

	@Given("the user launches the {string} Browser and is on Login Page")
	public void the_user_launches_the_browser(String browser) {
		loginPage = new LoginPage(Browser.CHROME);
	}

	@When("the user enters the credentials {string} and {string}")
	public void the_user_enters_the_credentials(String userName, String password) {

		fdDashboardPage = loginPage.doLoginWith(userName, password);
	}

	@Then("the user should see the userName under userIcon")
	public void the_user_should_see_the_userName_under_userIcon() {
		Assert.assertEquals(fdDashboardPage.getUserName(), "iamfd");
	}

}
