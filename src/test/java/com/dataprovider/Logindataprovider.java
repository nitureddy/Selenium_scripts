package com.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Logindataprovider {
	
	@DataProvider(name = "Get Data form Excel")
	public String[][] loginDP() {
		try {
			return com.api.excelData.LoginDataExcel.exceldata("userdata.xlsx", "LoginDetails");
		} catch (IOException e) {
			// TODO: handle exception
			e.fillInStackTrace();
		}
		
		return null;
		
	}

}
