package com.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.utils.Machine;

public class Runner {

	/*
	 * Take run time arguments (args) : env,testType,component Dynamic XML file-->
	 * Test will start to execute
	 * 
	 * 
	 */

	public static String env, testType, component, name, browserName, machineType;
	public static Machine m;
	public static void main(String[] args) {
// env testType component 

		if (verifyEnvType(args[0]) && verifyTestType(args[1]) && verifyComponentType(args[2])
				&& verifyBrowserName(args[3]) && verifymachineType(args[4])) {

			env = args[0].toLowerCase();
			testType = args[1].toLowerCase();
			component = args[2].toLowerCase();
			browserName = args[3].toLowerCase();
			machineType = args[4].toUpperCase();
			m = Machine.valueOf(machineType);	//how to convert string to enum;
		
			name = env + "_" + testType + "_" + component;
			generateDynamicXML();
		}

		else {
			System.out.println("Invalid Config!!! Please select the right config to begin the test");
			System.exit(0);
		}

		System.out.println(env);
		System.out.println(testType);
		System.out.println(component);

	}

	/**
	 * @param string
	 * @return
	 */
	private static boolean verifymachineType(String machineType) {
		// TODO Auto-generated method stub
		if (machineType.equalsIgnoreCase("LOCAL") || machineType.equalsIgnoreCase("BS")
				|| machineType.equalsIgnoreCase("LAMBDA")) {
			return true;
		} else {
			System.err.println(
					"Invalid machine Type  Valid Values are BS /LAMBDA /LOCAL (if you want to do local testing");
			System.out.println("Pleasue Use BS or LAMBDA for CI tools ");
			return false;
		}
	}

	/**
	 * @param string
	 * @return
	 */
	private static boolean verifyBrowserName(String browserName) {
		// TODO Auto-generated method stub
		if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("firefox")) {
			return true;
		} else {
			System.err.println("Invalid BrowserName  Valid Values are Firefox /Chrome");
			return false;
		}
	}

	// Heart
	private static void generateDynamicXML() {
		// TODO Auto-generated method stub
		System.out.println("Create a Custom dynamic testng Xml file ");

		TestNG myTestNG = new TestNG();

		// Create an instance of XML Suite and assign a name for it.
		XmlSuite mySuite = new XmlSuite();
		mySuite.setName(name + "_Suite");

		// Create an instance of XmlTest and assign a name for it.
		XmlTest myTest = new XmlTest(mySuite);
		myTest.setName(name + "_MyTest");

		// Add any parameters that you want to set to the Test.
		// myTest.setParallel(ParallelMode.TRUE);

//		if (component.equalsIgnoreCase("ui")) { // Used for the UI Test
//			HashMap<String, String> data = new HashMap<String, String>();
//			data.put("env", remoteTest);
//			myTest.setParameters(data);
//			System.out.println("Hiii");
//		}
		// Create a list which can contain the classes that you want to run.
//		List<XmlClass> myClasses = new ArrayList<XmlClass>();
//		myClasses.add(new XmlClass("com.api.test.ProductAPITestWithExcelFile"));
//Running all Package
		XmlPackage xmlPackage1 = new XmlPackage("com." + component + ".tests");
		List<XmlPackage> myPackage = new ArrayList<XmlPackage>();
		myPackage.add(xmlPackage1);
		System.out.println("com." + component + ".tests");

		// Assign that to the XmlTest Object created earlier.
		// myTest.setXmlClasses(myClasses);
		myTest.setPackages(myPackage);

		myTest.addIncludedGroup("e2e"); // *************
		// Create a list of XmlTests and add the Xmltest you created earlier to it.
		List<XmlTest> myTests = new ArrayList<XmlTest>();
		myTests.add(myTest);

		// add the list of tests to your Suite.
		mySuite.setTests(myTests);

		// Add the suite to the list of suites.
		List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		mySuites.add(mySuite);

		// Set the list of Suites to the testNG object you created earlier.
		myTestNG.setXmlSuites(mySuites);

		// invoke run() - this will run your class.
		myTestNG.run();

	}

	private static boolean verifyEnvType(String env) {
		// TODO Auto-generated method stub

		if (env.equalsIgnoreCase("DEV") || env.equalsIgnoreCase("QA") || env.equalsIgnoreCase("UAT")) {
			return true;
		} else {
			System.err.println("Invalid Env type Valid Values are DEV/QA or UAT");
			return false;
		}
	}

	private static boolean verifyTestType(String testType) {
		// TODO Auto-generated method stub

		if (testType.equalsIgnoreCase("sanity") || testType.equalsIgnoreCase("smoke")
				|| testType.equalsIgnoreCase("e2e") || testType.equalsIgnoreCase("regression")) {
			return true;
		} else {
			System.err.println("Invalid testType type Valid Values are sanity / smoke /regression or e2e");
			return false;
		}
	}

	private static boolean verifyComponentType(String component) {
		// TODO Auto-generated method stub

		if (component.equalsIgnoreCase("api") || component.equalsIgnoreCase("ui")) {
			return true;
		} else {
			System.err.println("Invalid component type Valid Values are api");
			return false;
		}
	}
}
