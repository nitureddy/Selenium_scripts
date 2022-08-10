package com.readcsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCSVCode {

	public static void main(String[] args) throws IOException, CsvException {
		// WHere the file: Location
		File myFile = new File(System.getProperty("user.dir") + "//testData//loginCreditals.csv");
		FileReader myFileReader = new FileReader(myFile);
		CSVReader csvReader = new CSVReader(myFileReader);
		List<String[]> dataList = csvReader.readAll();
		
		
		String[] x = new String[1];
		for (String[] stringArray : dataList) {
			for (String d : stringArray) {
				System.out.print(d + " ");
			}
			System.out.println("");
		}
	}
}
