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
public class PhoenixLoginScript {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver wd = new ChromeDriver();
		Thread.sleep(5000);
		
		wd.get("http://www.phoenix.testautomationacademy.in/sign-in");
		
		wd.manage().window().maximize();
		
		By userNameTextBoxLocator = By.id("username");
		By passwordTextBoxLocator = By.id("password");
		Thread.sleep(1000);

		WebElement userNameTextBoxElement = wd.findElement(userNameTextBoxLocator);// NoSuchElementException - If no
																					// matching elements are found
		userNameTextBoxElement.clear();
		userNameTextBoxElement.sendKeys("iamsup");
		Thread.sleep(1000);

		WebElement passwordTextBoxElement = wd.findElement(passwordTextBoxLocator);
		passwordTextBoxElement.clear();
		passwordTextBoxElement.sendKeys("password");
		Thread.sleep(1000);

		By signInButtonLocator = By.xpath("//span[contains(text(),\"Sign in\")]/../..");
		WebElement signInButtonElement = wd.findElement(signInButtonLocator);
		signInButtonElement.click();

	}
}
