/**
 * 
 */
package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.Browser;
import com.utils.BrowserUtility;
import com.utils.Machine;

/**
 * @author Jatin
 *
 */
public final class LoginPage extends BrowserUtility {
	/*
	 * variables---locators functions---- functionality of the page (needs to return
	 * Something)
	 * 
	 * Functions will return Page Objects or a value
	 */

	/**
	 * @param browser
	 */

	private static final By USERNAME_TEXTBOX_LOCATOR = By.id("username");
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("password");
	private static final By SIGN_IN_BUTTON_LOCATOR = By.xpath("//span[contains(text(),\"Sign in\")]/../..");

	public LoginPage(Browser browser) {
		super(browser); // Constructor Chaining
		// TODO Auto-generated constructor stub\
		goToWebSite("http://www.phoenix.testautomationacademy.in/");
		maximizeTheWindow();

	}

	public LoginPage(Browser browser,Machine m) {
		super(browser,m); // Constructor Chaining
		// TODO Auto-generated constructor stub\
		goToWebSite("http://www.phoenix.testautomationacademy.in/");
		maximizeTheWindow();

	}

	public FDDashboardPage doLoginWith(String userName, String password) {
		enterText(USERNAME_TEXTBOX_LOCATOR, userName);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SIGN_IN_BUTTON_LOCATOR);
		FDDashboardPage f = new FDDashboardPage(getWd());
		return f;
	}
}
