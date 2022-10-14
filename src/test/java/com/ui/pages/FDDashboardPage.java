/**
 * 
 */
package com.ui.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.day2.Browser;
import com.day2.BrowserUtility;
import com.ui.pojo.FDDashBoardTablePOJO;

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

	private static final By CREATED_JOB_TODAY = By.xpath("//div[contains(text(),\"Created today\")]/../div[1]/button");

	private static final By FD_DASHBOARD_TABLE = By.tagName("mat-table");

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

	public ArrayList<FDDashBoardTablePOJO>  getDataFromTable() {
		WebDriver wd = getWd();
		clickOn(CREATED_JOB_TODAY);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement tableElement = wd.findElement(FD_DASHBOARD_TABLE);
		By rowLocator = By.xpath("//mat-row");
		By cellLocator = By.xpath("//mat-cell");
		ArrayList<FDDashBoardTablePOJO> data = new ArrayList<FDDashBoardTablePOJO>();
		List<WebElement> rowList = tableElement.findElements(rowLocator);
		for (WebElement rowElement : rowList) {

			List<WebElement> cellList = rowElement.findElements(By.xpath(".//mat-cell"));
			data.add(new FDDashBoardTablePOJO(cellList.get(0).getText(), cellList.get(1).getText(),
					cellList.get(2).getText(), cellList.get(3).getText(), cellList.get(4).getText(),
					cellList.get(5).getText(), cellList.get(6).getText()));
		}
		return data;
	}

}
