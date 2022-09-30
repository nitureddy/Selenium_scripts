/**
 * 
 */
package com.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.day2.Browser.*;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Jatin
 *
 */
public class PhoenixLoginScript3 {
	public static void main(String[] args) throws InterruptedException {

		BrowserUtility bu = new BrowserUtility(CHROME);
		bu.goToWebSite("http://www.phoenix.testautomationacademy.in/sign-in");
		bu.maximizeTheWindow();
		bu.enterText(By.id("username"), "iamfd");
		bu.enterText(By.id("password"), "password");
		bu.clickOn(By.xpath("//span[contains(text(),\"Sign in\")]/../.."));
		bu.enterText(By.xpath("//input[@data-placeholder=\"Search for a Job or IMEI\"]"), "JOB_14061");
		bu.enterText(By.xpath("//input[@data-placeholder=\"Search for a Job or IMEI\"]"), Keys.ENTER);
	}
}
