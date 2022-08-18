package com.utils;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hamcrest.Matchers;

import com.github.javafaker.Faker;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.pojo.CreateJobPOJO;
import com.pojo.CustomerAddressPOJO;
import com.pojo.CustomerPOJO;
import com.pojo.CustomerProductPOJO;
import com.pojo.LoginPOJO;
import com.pojo.ProblemPOJO;

import io.restassured.http.Header;

public class TestUtil {

	public static CreateJobPOJO getCreateJobData() {
		// String imei = createIMEINumber();
		CustomerPOJO customerInfoPOJO = new CustomerPOJO("vaibhav", "Kalshetti", "9705593183", "970555445",
				"vaibhav@gmail.com", "");
		CustomerAddressPOJO customerAddressPOJO = new CustomerAddressPOJO("101", "abc apt", "street name1",
				"near ayyapa temple", "kukatpally", "500072", "India", "Andhra Pradesh");
		CustomerProductPOJO customerProductPOJO = new CustomerProductPOJO("2022-04-05T18:30:00.000Z", "62344567123411",
				"62344567123411", "62344567123411", "2022-04-05T18:30:00.000Z", 1, 2);
		ProblemPOJO[] problems = new ProblemPOJO[3];
		problems[0] = new ProblemPOJO(1, "battery drains quickly");
		problems[1] = new ProblemPOJO(4, "camera not working");
		problems[2] = new ProblemPOJO(3, "app crashes");

		CreateJobPOJO createJobPOJO = new CreateJobPOJO(0, 2, 1, 1, customerInfoPOJO, customerAddressPOJO,
				customerProductPOJO, problems);
		System.out.println(createJobPOJO.toJson());
		return createJobPOJO;
	}

	public static CreateJobPOJO getCreateJobDataWithFaker() {
		// String imei = createIMEINumber();
		Faker faker = new Faker(Locale.ENGLISH);
		String imei = faker.numerify("##############");
		CustomerPOJO customerInfoPOJO = new CustomerPOJO(faker.address().firstName(), faker.address().lastName(),
				faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), faker.internet().emailAddress(), "");
		CustomerAddressPOJO customerAddressPOJO = new CustomerAddressPOJO("101", "abc apt", "street name1",
				"near ayyapa temple", "kukatpally", "500072", "India", "Andhra Pradesh");
		CustomerProductPOJO customerProductPOJO = new CustomerProductPOJO("2022-04-05T18:30:00.000Z", imei, imei, imei,
				"2022-04-05T18:30:00.000Z", 1, 2);
		ProblemPOJO[] problems = new ProblemPOJO[3];
		problems[0] = new ProblemPOJO(1, "battery drains quickly");
		problems[1] = new ProblemPOJO(4, "camera not working");
		problems[2] = new ProblemPOJO(3, "app crashes");

		CreateJobPOJO createJobPOJO = new CreateJobPOJO(0, 2, 1, 1, customerInfoPOJO, customerAddressPOJO,
				customerProductPOJO, problems);
		System.out.println(createJobPOJO.toJson());
		return createJobPOJO;
	}

	public static String generateToken() {
		String token = given().when().header(new Header("content-type", "application/json")).and()
				.body(new LoginPOJO("iamfd", "password").toJson()).and().post("v1/login").then().log().all().and()
				.assertThat().statusCode(200).and().assertThat().body(Matchers.containsString("Success")).and()
				.extract().jsonPath().getString("data.token");
		System.out.println("-------------" + token);
		return token;

	}

	public static Iterator<String[]> readCSVFile(String fileName) {
		// WHere the file: Location
		File myFile = new File(System.getProperty("user.dir") + "//testData//" + fileName);
		FileReader myFileReader = null;
		List<String[]> dataList = null;
		CSVReader csvReader = null;
		try {
			myFileReader = new FileReader(myFile);
			csvReader = new CSVReader(myFileReader);
			dataList = csvReader.readAll();
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to find the file!! Check the file path");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read the file!!");
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to read the CSV file!! Is the filetype csv?");
		}

		Iterator<String[]> dataIterator = dataList.iterator();
		dataIterator.next(); // 0...1
		return dataIterator;
	}

	public static String[][] readExcel() throws InvalidFormatException, IOException {

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

		String[][] data = new String[lastRowIndex][totalNumberCols];

		for (int rowIndex = 1; rowIndex <= lastRowIndex; rowIndex++) {

			for (int colIndex = 0; colIndex < totalNumberCols; colIndex++) {
				myRow = mySheet.getRow(rowIndex);
				myCell = myRow.getCell(colIndex);
				data[rowIndex-1][colIndex] = myCell.toString();

			}
		}

		return data;
	}

}
