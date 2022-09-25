package com.api.excelData;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class LoginDataExcel {

	public static String[][] exceldata(String filename, String sheetname) throws IOException {
		XSSFWorkbook myworkbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\testdata\\"+filename);
		XSSFSheet mysheet = myworkbook.getSheet(sheetname);
		XSSFRow firstrow = mysheet.getRow(0);
		XSSFRow myrow;
		XSSFCell mycell;
		int lastrowindex = mysheet.getLastRowNum();
		int lastcolindex = firstrow.getLastCellNum();
		String[][] data = new String[lastrowindex][lastcolindex];
		for (int r = 1; r <= lastrowindex; r++) {
			for (int c = 0; c < lastcolindex; c++) {
				myrow = mysheet.getRow(r);
				mycell = myrow.getCell(c);
				data[r - 1][c] = mycell.getStringCellValue();
			}
		}
		myworkbook.close();
		return data;
	}

}
