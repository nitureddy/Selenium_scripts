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
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hamcrest.Matchers;

import com.api.pojo.CreateNewJob;
import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;
import com.api.pojo.CustomerProduct;
import com.api.pojo.IBodyJson;
import com.api.pojo.PhoenixLoginCredentialsPOJO;
import com.api.pojo.Problems;
import com.github.javafaker.Faker;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.runner.Runner;
import static io.restassured.RestAssured.*;
import io.restassured.http.Header;

/**
 * 1.Contains common utils functions to write tests<br>
 * 2.Generates tokens for the api requests <br>
 * 3.Reading properties <br>
 * 4.Reading Files like (CSV or Excel) <br>
 * 
 * @author Jatin
 *
 */
public final class TestUtils {

	/**
	 * Generates a constant fake data for create job api request with userInfo:<br>
	 * <b>Name</b> : vaibhav <br>
	 * <b>Last Name</b> : Kalshetti <br>
	 * <b>Contact Number</b> : 9705593183 <br>
	 * <b>Email Address</b> : vaibhav@gmail.com <br>
	 * <b>return</b> Object reference of CreateNewJob POJO <br>
	 * <br>
	 * 
	 * @author Jatin jatin@testautomationacademy.in
	 *
	 */
	public static CreateNewJob getCreateJobData() {
		Faker faker = new Faker();
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		String emailid = lastname + firstname + "001@gmail.com";
		String imei = faker.numerify("###############");
		Customer customerInfoPOJO = new Customer(firstname, lastname, "9703334456", "970555445", emailid,
				emailid);
		CustomerAddress customerAddressPOJO = new CustomerAddress(faker.address().buildingNumber(), "abc apt", "street name1",
				faker.address().streetName(), faker.address().cityName(), "500072", "India", "Andhra Pradesh");
		CustomerProduct customerProductPOJO = new CustomerProduct(timeStampforJobCreation(), imei,
				imei, imei, timeStampforJobCreation(), 1, 2);
		Problems[] problems = new Problems[3];
		problems[0] = new Problems(1, "battery drains quickly");
		problems[1] = new Problems(4, "camera not working");
		problems[2] = new Problems(3, "app crashes");

		CreateNewJob createJobPOJO = new CreateNewJob(0, 2, 1, 1, customerInfoPOJO, customerAddressPOJO,
				customerProductPOJO, problems);
		System.out.println(createJobPOJO.toJson());
		return createJobPOJO;
	}
	
	public static String timeStampforJobCreation() {

		Date d1 = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.000Z'");
		return dateFormat.format(d1);
	}

	/**
	 * Generates a random IMEI Number for Job Creation {@code TestUtils} is a
	 * <b>final</b> class. generateIMEI (static functions) <b>returns</b>: a random
	 * IMEI number <br>
	 * 
	 * @author Jatin jatin@testautomationacademy.in
	 *
	 */
	public static String generateIMEI() {
		Random imeinumber = new Random();
		String imei = "7867785975323" + imeinumber.nextInt(1000);
		return imei;
	}

	/**
	 * Helps in reading Properties value for Environment <br>
	 * Properties File are stored in config folder <br>
	 * Access Information like: <br>
	 * <b> 1.BaseURL <br>
	 * </b> <b> 2.DB Info <br>
	 * </b> <b> 3.BrowserStack Information <br>
	 * </b>
	 * 
	 * @author Jatin jatin@testautomationacademy.in
	 *
	 */
	public static String getProperties(String keyName) {
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

		String data = prop.getProperty(keyName);
		return data;
	}

	/**
	 * Generates a random Token for Authorization Purpose {@code TestUtils} is a
	 * <b>final</b> class. generateToken (static functions) <b>returns</b>: random
	 * Token for Authorization.
	 * 
	 * @author Jatin jatin@testautomationacademy.in
	 *
	 */
	public static String generateToken(String role) {
		if (role.equalsIgnoreCase("FD")) {
			String token = given().when().header(new Header("content-type", "application/json")).and()
					.body(new PhoenixLoginCredentialsPOJO("iamfd", "password").toJson()).and().post("v1/login").then().extract().jsonPath().getString("data.token");
			return token;
			
		} else if (role.equalsIgnoreCase("SUP")) {
			String token = given().when().header(new Header("content-type", "application/json")).and()
					.body(new PhoenixLoginCredentialsPOJO("iamsup", "password").toJson()).and().post("v1/login").then().extract().jsonPath().getString("data.token");
			return token;
			
			
		} else if (role.equalsIgnoreCase("ENG")) {
			String token = given().when().header(new Header("content-type", "application/json")).and()
					.body(new PhoenixLoginCredentialsPOJO("iameng", "password").toJson()).and().post("v1/login").then().extract().jsonPath().getString("data.token");
			return token;
		} else if (role.equalsIgnoreCase("QC")) {
			String token = given().when().header(new Header("content-type", "application/json")).and()
					.body(new PhoenixLoginCredentialsPOJO("iamqc", "password").toJson()).and().post("v1/login").then().extract().jsonPath().getString("data.token");
			return token;
		} else {
			String token = given().when().header(new Header("content-type", "application/json")).and()
					.body(new PhoenixLoginCredentialsPOJO("iamfd", "password").toJson()).and().post("v1/login").then().extract().jsonPath().getString("data.token");
			return token;

		}
		
	}

	/**
	 * Generates a random Token for Authorization Purpose {@code TestUtils} is a
	 * <b>final</b> class. generateToken (static functions) <b>returns</b>: random
	 * Token for Authorization.
	 * 
	 * @author Jatin jatin@testautomationacademy.in
	 *
	 */
	public static String generateUserToken(UserRole role) {
		IBodyJson body = null;
		if (role == UserRole.FD) {
			body = new PhoenixLoginCredentialsPOJO("iamfd", "password");
		} else if (role == UserRole.ENG) {
			body = new PhoenixLoginCredentialsPOJO("iameng", "password");
		}

		else if (role == UserRole.SUP) {
			body = new PhoenixLoginCredentialsPOJO("iamsup", "password");
		}

		else if (role == UserRole.QC) {
			body = new PhoenixLoginCredentialsPOJO("iamqc", "password");
		}

		else if (role == UserRole.FST) {
			body = new PhoenixLoginCredentialsPOJO("iamfst1", "password");
		}
		String token = given().when().header(new Header("content-type", "application/json")).and().body(body.toJson())
				.and().post("v1/login").then().log().all().and().assertThat().statusCode(200).and().assertThat()
				.body(Matchers.containsString("Success")).and().extract().jsonPath().getString("data.token");
		System.out.println("-------------" + token);
		return token;

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
