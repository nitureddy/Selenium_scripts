package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.runner.Runner;

public final class TestUtils {

	public static String timeStampforJobCreation() {

		Date d1 = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.000Z'");
		return dateFormat.format(d1);
	}

	public static String generateIMEI() {
		Random imeinumber = new Random();
		String imei = "7867785975323" + imeinumber.nextInt(1000);
		return imei;
	}

	public static String getProperties(String key) {
		Runner.env = "dev";
		File myFile = new File(System.getProperty("user.dir") + "//config//" + Runner.env + ".properties");
		Reader reader = null;
		try {
			reader = new FileReader(myFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		String data = prop.getProperty(key);
		return data;
	}

	public static String[][] getDataFromExcel(String fileName, String sheetName) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook myWorkbook = new XSSFWorkbook(System.getProperty("user.dir") + "//testData//" + fileName);
		XSSFSheet mySheet = myWorkbook.getSheet(sheetName);
		int lastRowIndex = mySheet.getLastRowNum();
		XSSFRow rowHeaders = mySheet.getRow(1); // col names;
		int totalNumberOfColsinTheSheet = rowHeaders.getLastCellNum();
		XSSFRow myRow;
		XSSFCell myCell;
		
		String[][] data = new String[lastRowIndex][totalNumberOfColsinTheSheet];

		for (int row = 1; row <= lastRowIndex; row++) {
			for (int col = 0; col < totalNumberOfColsinTheSheet; col++) {
				myRow = mySheet.getRow(row);
				myCell = myRow.getCell(col);
				data[row - 1][col] = myCell.getStringCellValue();
			}

		}

		return data;
	}

	public static Iterator<String[]> readCSVFile(String fileName) {
		String path = System.getProperty("user.dir") + "\\testData\\" + fileName;
		File myFile = new File(path);
		Reader reader = null;
		List<String[]> dataList = null;
		CSVReader myCSVReader;
		try {
			reader = new FileReader(myFile);
			myCSVReader = new CSVReader(reader); // OPENCSV
			dataList = myCSVReader.readAll();
			myCSVReader.close();
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator<String[]> dataIterator = dataList.iterator(); // DP
		dataIterator.next();

		return dataIterator;

	}
}