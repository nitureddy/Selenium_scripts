/**
 * 
 */
package com.pages;

import static com.day2.Browser.CHROME;

import org.openqa.selenium.By;

import com.day2.Browser;
import com.day2.BrowserUtility;

/**
 * @author Jatin
 *
 */
public class Runner {

	/**
	 * @param args
	 */

	/*
	 * BrowserUtility bu = new BrowserUtility(CHROME);
	 * bu.goToWebSite("http://www.phoenix.testautomationacademy.in/sign-in");
	 * bu.maximizeTheWindow(); bu.enterText(By.id("username"), "iamfd");
	 * bu.enterText(By.id("password"), "password");
	 * bu.clickOn(By.xpath("//span[contains(text(),\"Sign in\")]/../.."));
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginPage loginPage = new LoginPage(Browser.CHROME);
		loginPage.doLoginWith("iamfd", "password").searchForJob("JOB_17794");
	}

}
