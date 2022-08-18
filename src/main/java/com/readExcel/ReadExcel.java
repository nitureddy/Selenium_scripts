package com.readExcel;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws InvalidFormatException, IOException {

		// Java Where the .xlsx file

		File myFile = new File(System.getProperty("user.dir") + "//testData//TestData.xlsx");

		XSSFWorkbook myWorkBook = new XSSFWorkbook(myFile);

		XSSFSheet mySheet = myWorkBook.getSheetAt(0);

		XSSFRow myRow;

		XSSFCell myCell;

		// System.out.println(myCell.toString());
//row 0 to 1
// 0 to 1
		int lastRowIndex = mySheet.getLastRowNum();
		XSSFRow rowHeader = mySheet.getRow(0);
		int totalNumberCols = rowHeader.getLastCellNum();

		String[][] data = new String[lastRowIndex + 1][totalNumberCols];

		for (int rowIndex = 0; rowIndex <= lastRowIndex; rowIndex++) {

			for (int colIndex = 0; colIndex < totalNumberCols; colIndex++) {
				myRow = mySheet.getRow(rowIndex);
				myCell = myRow.getCell(colIndex);
				data[rowIndex][colIndex] = myCell.toString();
				System.out.println(myCell.toString());
			}
		}

		// for loop
	}
}
