package com.dataproviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.utils.TestUtil;

public class LoginDataProvider {
@DataProvider (name = "loginDP")
	public Iterator<String[]> loginTestDataProvider() {
	//Bring data to the test @test
	
	java.util.Iterator<String[]> data = TestUtil.readCSVFile("loginCreditals.csv");
	return data;
}
	
}
