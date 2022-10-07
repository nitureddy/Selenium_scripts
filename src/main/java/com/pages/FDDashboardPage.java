/**
 * 
 */
package com.pages;

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
}
