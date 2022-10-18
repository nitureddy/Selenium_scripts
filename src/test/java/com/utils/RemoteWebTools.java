/**
 * 
 */
package com.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.runner.Runner;

/**
 * @author Jatin
 *
 */
public class RemoteWebTools {

	public static class BrowserStack {
		private static final String USERNAME = TestUtils.getProperties("USERNAME");
		private static final String AUTOMATE_KEY = TestUtils.getProperties("ACCESS_KEY");
		private static final String REMOTE_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY
				+ "@hub.browserstack.com/wd/hub";;

		public WebDriver launchRemoteWebDriver(WebDriver wd) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("browserName", Runner.browserName);
			capabilities.setCapability("browserVersion", "latest");
			capabilities.setCapability("os", "Windows");
			capabilities.setCapability("osVersion", "11");
			capabilities.setCapability("resolution", "1920x1200");

			try {
				wd = new RemoteWebDriver(new URL(REMOTE_URL), capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return wd;
		}

	}

	public static class LambdaTest {
		private static final String USERNAME = "jatinvsharma1824";
		private static final String ACCESS_KEY = "m3QEQqHf0RmhepbW8bu2hoGQvJPpkPgTJS9B2QYC2PZjw7GmDF";
		private static final String GRID_URL = "@hub.lambdatest.com/wd/hub";

		public WebDriver launchRemoteWebDriver(WebDriver wd) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("browserName", Runner.browserName);
			capabilities.setCapability("version", "70.0");
			capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any
																// available one.
			capabilities.setCapability("build", "LambdaTestSampleApp");
			capabilities.setCapability("name", "LambdaTestJavaSample");
			try {
				wd = new RemoteWebDriver(new URL("https://" + USERNAME + ":" + ACCESS_KEY + GRID_URL), capabilities);
			} catch (MalformedURLException e) {
				System.out.println("Invalid grid URL");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return wd;

		}
	}

}
