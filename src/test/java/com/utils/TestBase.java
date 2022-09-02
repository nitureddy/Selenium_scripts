package com.utils;

import static io.restassured.RestAssured.baseURI;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;

public class TestBase {

	public static HashMap<String, String> tokenMap;

	@BeforeTest(description = "intializing  the baseURI, creating the testData for api testing", alwaysRun = true) // before
																													// will
																													// be
																													// //
																													// called
																													// befo
																													// //
																													// every@Test
	public void setup() {
		baseURI = "http://139.59.91.96:9000";
		
	}
}
