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
		bu.clickOn(By.xpath("//span[contains(text(),\"Create Job\")]/../../.."));
		bu.enterText(By.xpath("//input[@formcontrolname='imeiNo1']"), "12324353536");
		bu.enterText(By.xpath("//input[@id='mat-input-4']"), "3/10/2022");
		bu.enterText(By.xpath("//input[@placeholder='Remarks']"), "Test");
		bu.enterText(By.xpath("//input[@formcontrolname='firstName']"), "Test");
		bu.enterText(By.xpath("//input[@formcontrolname='lastName']"), "Test");
		bu.enterText(By.xpath("//input[@formcontrolname='contactNo']"), "11111111111");

	}
}
