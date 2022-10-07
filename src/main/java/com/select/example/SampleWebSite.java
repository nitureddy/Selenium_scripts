/**
 * 
 */
package com.select.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Jatin
 *
 */
public class SampleWebSite {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); // Download the specific version of chromedriver for my machine
		WebDriver wd = new ChromeDriver(); // A new browser session is going started!
		wd.get("http://139.59.91.96:5001/selenium-workbook/registration-form.html");

		wd.manage().window().maximize();
		Thread.sleep(5000);

		By hearAboutDropDownLocator = By.name("hearAbout");
		WebElement hearAboutDropDownElement = wd.findElement(hearAboutDropDownLocator);

		Select hearAboutDropDown = new Select(hearAboutDropDownElement);

		hearAboutDropDown.selectByVisibleText("Friend");
		Thread.sleep(3000);
		hearAboutDropDown.selectByVisibleText("Advert");

		By interestDropDownLocator = By.name("interest");
		WebElement interestDropDownElement = wd.findElement(interestDropDownLocator);

		Select interestDropDown = new Select(interestDropDownElement);
		interestDropDown.selectByIndex(2);
		Thread.sleep(3000);

		interestDropDown.selectByIndex(1);

	}

}
