/**
 * 
 */
package com.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Jatin
 *
 */
public class BrowserUtility {

	private WebDriver wd;

	public BrowserUtility(WebDriver wd) {
		super();
		this.wd = wd;
	}

	public BrowserUtility(Browser browser) {
		if (browser == Browser.CHROME) {
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();
		} else if (browser == Browser.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			wd = new ChromeDriver();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterText(By elementLocator, String textToEnter) {
		WebElement element = wd.findElement(elementLocator);
		element.clear();
		element.sendKeys(textToEnter);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterText(By elementLocator, Keys KeyToEnter) {
		WebElement element = wd.findElement(elementLocator);
		element.clear();
		element.sendKeys(KeyToEnter);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void goToWebSite(String url) {
		wd.get(url);
	}

	public void maximizeTheWindow() {
		wd.manage().window().maximize();
	}

	public void clickOn(By elementLocator) {
		WebElement element = wd.findElement(elementLocator);
		element.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
