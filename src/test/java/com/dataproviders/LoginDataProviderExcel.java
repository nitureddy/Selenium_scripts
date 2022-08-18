package com.dataproviders;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.utils.TestUtil;

public class LoginDataProviderExcel {

	@DataProvider(name = "loginDPExcel")
	public String[][] loginTestDatProvider() {
//Bring data to the test @test
		/*
		 * Object[] Object[][] Iterator<Object>
		 * 
		 */
		String[][] data = null;
		try {
			data = TestUtil.readExcel();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		return data;
	}

}
