/**
 * 
 */
package com.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Jatin
 *
 */
public class PhoenixLoginScript_Sync {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver wd = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(wd, 30);
		// Polling

		Thread.sleep(5000);

		wd.get("http://www.phoenix.testautomationacademy.in/sign-in");

		wd.manage().window().maximize();

		By userNameTextBoxLocator = By.id("username");
		By passwordTextBoxLocator = By.id("password");

		// WebElement userNameTextBoxElement = wd.findElement(userNameTextBoxLocator);//
		// NoSuchElementException - If no

		WebElement userNameTextBoxElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(userNameTextBoxLocator));
		// TimeoutException - If the timeout expires.
		// matching elements are found
		userNameTextBoxElement.clear();
		userNameTextBoxElement.sendKeys("iamsup");

		// WebElement passwordTextBoxElement = wd.findElement(passwordTextBoxLocator);

		WebElement passwordTextBoxElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBoxLocator));
		passwordTextBoxElement.clear();
		passwordTextBoxElement.sendKeys("password");

		By signInButtonLocator = By.xpath("//span[contains(text(),\"Sign in\")]/../..");
		// WebElement signInButtonElement = wd.findElement(signInButtonLocator);
		WebElement signInButtonElement = wait.until(ExpectedConditions.elementToBeClickable(signInButtonLocator));

		signInButtonElement.click();

		By searchTextBoxLocator = By.xpath("//input[@data-placeholder=\"Search for a Job or IMEI\"]"); // NoSuchElementException:
																										// no
		// WebElement searchTextBoxElement = wd.findElement(searchTextBoxLocator);

		WebElement searchTextBoxElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(searchTextBoxLocator));
		searchTextBoxElement.sendKeys("JOB_14061");
		searchTextBoxElement.sendKeys(Keys.ENTER);
	}
}
