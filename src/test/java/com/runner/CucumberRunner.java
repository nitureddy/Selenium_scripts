package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = { "src/test/resources/simplefeatures/" }, 
		glue = { "com.stepdefinitions" },
		plugin = { "pretty",
		"html:target/cucumber-html-report.html", "json:target/cucumber.json" },
		monochrome = true)
public class CucumberRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
