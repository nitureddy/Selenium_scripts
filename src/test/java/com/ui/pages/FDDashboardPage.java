/**
 * 
 */
package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.day2.Browser;
import com.day2.BrowserUtility;

/**
 * @author Jatin
 *
 */
public class FDDashboardPage extends BrowserUtility {

	private static final By SEARCH_TEXT_BOX_LOCATOR = By
			.xpath("//input[@data-placeholder=\"Search for a Job or IMEI\"]"); // NoSuchElementException:

	private static final By USER_ICON_LOCATOR = By.xpath("//mat-icon[@data-mat-icon-name=\"user-circle\"]");

	private static final By USERNAME_LOCATOR = By.xpath("//span[contains(text(),\"Signed in as\")]/../span[2]");
	private static final By CREATE_JOB_LINK_LOCATOR = By.xpath("//span[contains(text(),\"Create Job\")]/../../..");

	public FDDashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void searchForJob(String viaJobNumberOrIMEI) {
		enterText(SEARCH_TEXT_BOX_LOCATOR, viaJobNumberOrIMEI);
		enterText(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);

	}

	public FDDashboardPage and() {
		return new FDDashboardPage(getWd());
	}

	public String getUserName() {
		clickOn(USER_ICON_LOCATOR);
		return getVisibleText(USERNAME_LOCATOR);

	}
	
	
	public CreateJobPage goToCreateJobPage() {
		clickOn(CREATE_JOB_LINK_LOCATOR);
		return new CreateJobPage(getWd());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
