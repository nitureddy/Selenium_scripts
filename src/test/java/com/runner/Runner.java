package com.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Runner {

	/*
	 * Take run time arguments (args) : env,testType,component Dynamic XML file-->
	 * Test will start to execute
	 * 
	 * 
	 */

	public static String env, testType, component, name;

	public static void main(String[] args) {
// env testType component 

		if (verifyEnvType(args[0]) && verifyTestType(args[1]) && verifyComponentType(args[2])) {

			env = args[0].toLowerCase();
			testType = args[1].toLowerCase();
			component = args[2].toLowerCase();
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

	// Heart
	private static void generateDynamicXML() {
		// TODO Auto-generated method stub
		System.out.println("Create a Custom dynamic testng Xml file ");

		TestNG mytestNg = new TestNG();

		// Create a test suite
		XmlSuite myXmlSuite = new XmlSuite();
		myXmlSuite.setName(name + " Suite");

		// Create Test
		XmlTest myXmltest = new XmlTest();
		myXmltest.setName(name + "Test");
		System.out.println("com." + component + ".test2");
		XmlPackage myxmlpackage = new XmlPackage("com." + component + ".test");

		List<XmlPackage> mypackageList = new ArrayList<XmlPackage>();
		mypackageList.add(myxmlpackage);
		myXmltest.setPackages(mypackageList);
		myXmltest.addIncludedGroup("sanity");

		List<XmlTest> myTestList = new ArrayList<XmlTest>();
		myTestList.add(myXmltest);

		List<XmlSuite> mySuiteList = new ArrayList<XmlSuite>();
		mySuiteList.add(myXmlSuite);

		mytestNg.setXmlSuites(mySuiteList);

		mytestNg.run();
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

		if (component.equalsIgnoreCase("api")) {
			return true;
		} else {
			System.err.println("Invalid component type Valid Values are api");
			return false;
		}
	}
}
