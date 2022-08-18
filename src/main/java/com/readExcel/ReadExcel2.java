package com.readExcel;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel2 {
	public static void main(String[] args) throws InvalidFormatException, IOException {

		// Java Where the .xlsx file

		File myFile = new File(System.getProperty("user.dir") + "//testData//TestData.xlsx");

		XSSFWorkbook myWorkBook = new XSSFWorkbook(myFile);

		XSSFSheet mySheet = myWorkBook.getSheetAt(0);

		int lastRowIndex = mySheet.getLastRowNum();

		XSSFRow rowHeader = mySheet.getRow(0);

		int totalNumberCols = rowHeader.getLastCellNum();
		System.out.println(totalNumberCols);
	}
}
