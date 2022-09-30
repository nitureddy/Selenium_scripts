/**
 * 
 */
package com.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Jatin
 *
 */
public class PhoenixLoginScript2 {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		Thread.sleep(5000);
		BrowserUtility bu = new BrowserUtility(wd);
		bu.goToWebSite("http://www.phoenix.testautomationacademy.in/sign-in");
		bu.maximizeTheWindow();
		bu.enterText(By.id("username"), "iamfd");
		bu.enterText(By.id("password"), "password");
		bu.clickOn(By.xpath("//span[contains(text(),\"Sign in\")]/../.."));

	}
}
