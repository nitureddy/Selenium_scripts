/**
 * 
 */
package com.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.pojo.FDDashBoardTablePOJO;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Jatin
 *
 */
public abstract class BrowserUtility {

	private WebDriver wd;
	private WebDriverWait wait;

	public BrowserUtility(WebDriver wd) {
		super();
		this.wd = wd;
		wait = new WebDriverWait(this.wd, 30);
	}

	public WebDriver getWd() {
		return wd;
	}

	public BrowserUtility(Browser browser) {
		if (browser == Browser.CHROME) {
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver(); // LOCAL
			wait = new WebDriverWait(this.wd, 30);

		} else if (browser == Browser.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			wd = new ChromeDriver();
			wait = new WebDriverWait(this.wd, 30);

		}
		try { // for me
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BrowserUtility(Browser browser, Machine m) {
		if (m == Machine.BS) {
			RemoteWebTools.BrowserStack bs = new RemoteWebTools.BrowserStack();
			wd = bs.launchRemoteWebDriver(wd);

		}

		else if (m == Machine.LAMBDA) {
			RemoteWebTools.LambdaTest lt = new RemoteWebTools.LambdaTest();
			wd = lt.launchRemoteWebDriver(wd);

		}

		wait = new WebDriverWait(this.wd, 30);
	}

	public void enterText(By elementLocator, String textToEnter) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		element.clear();
		element.sendKeys(textToEnter);

	}

	public void enterText(By elementLocator, Keys KeyToEnter) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		element.clear();
		element.sendKeys(KeyToEnter);

	}

	public void goToWebSite(String url) {
		wd.get(url);
	}

	public void maximizeTheWindow() {
		wd.manage().window().maximize();
	}

	public void clickOn(By elementLocator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
		element.click();

	}

	public String getVisibleText(By elementLocator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		return element.getText();

	}

	public void selectFromDropDown(String dropDownControlName, String value) {
		By oemDropDownLocator = By.xpath("//mat-select[@formcontrolname='" + dropDownControlName + "']");
		clickOn(oemDropDownLocator);

		By oemNameLocator = By.xpath("//span[contains(text(),'" + value + "')]/..");
		clickOn(oemNameLocator);
	}

	/*
	 * code is tightly coupled!
	 */
	public ArrayList<FDDashBoardTablePOJO> getDataFromTable(By buttonLocator, By tableLocator) {
		By rowLocator = By.xpath("//mat-row");
		By cellLocator = By.xpath(".//mat-cell");
		WebElement tableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(tableLocator));
		ArrayList<FDDashBoardTablePOJO> data = new ArrayList<FDDashBoardTablePOJO>();
		List<WebElement> rowList = tableElement.findElements(rowLocator);
		for (WebElement rowElement : rowList) {

			List<WebElement> cellList = rowElement.findElements(cellLocator);
			data.add(new FDDashBoardTablePOJO(cellList.get(0).getText(), cellList.get(1).getText(),
					cellList.get(2).getText(), cellList.get(3).getText(), cellList.get(4).getText(),
					cellList.get(5).getText(), cellList.get(6).getText()));
		}

		return data;
	}
}
