package com.runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class Runner2 {

	/*
	 * Take run time arguments (args) : env,testType,component Dynamic XML file-->
	 * Test will start to execute
	 * 
	 * 
	 */

	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
// env testType component 
			String s= "{\r\n"
					+ "\"name\" : \"abc\" ,\r\n"
					+ "\"email_id \" : [\"abc@gmail.com\",\"def@gmail.com\",\"ghi@gmail.com\"]\r\n"
					+ "}";
			
			Map<String, Object> response = new ObjectMapper().readValue(s, HashMap.class);

			
			System.out.println(response.get("name"));
	}
}
