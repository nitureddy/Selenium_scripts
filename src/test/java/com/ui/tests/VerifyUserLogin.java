/**
 * 
 */
package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.day2.Browser;
import com.ui.pages.LoginPage;

/**
 * @author Jatin
 *
 */
public class VerifyUserLogin {

	private LoginPage loginPage;

	@BeforeMethod(description = "setup of the Browser")
	public void setup() {
		loginPage = new LoginPage(Browser.CHROME);
	}

	@Test
	public void verifyUserLogin() {

		Assert.assertEquals(loginPage.doLoginWith("iamfd", "password").getUserName(), "iamfd");

	}
}
