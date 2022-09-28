/**
 * 
 */
package com.day1;

import java.sql.DriverManager;

import org.apache.poi.xwpf.usermodel.IBody;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Jatin
 *
 */
public class LaunchScript {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); // Download the specific version of chromedriver for my machine
		WebDriver wd = new ChromeDriver(); // A new browser session is going started!
		wd.get("http://www.phoenix.testautomationacademy.in/"); // Sync Code

//		// Manage the browser
//		Options o = wd.manage();
//		Window w = o.window();
//		w.maximize();

		wd.manage().window().maximize();// LINQ
		String title = wd.getTitle();
		System.out.println(title);
		String pageSource = wd.getPageSource();
		System.out.println(pageSource);

		// Locators help selenium to locate the html elements --- WebElements
		// 8

		By signInButtonLocator = By.xpath("//span[contains(text(), 'Sign in' )]/../..");
		WebElement element = wd.findElement(signInButtonLocator);//
		element.click();
	}
}
