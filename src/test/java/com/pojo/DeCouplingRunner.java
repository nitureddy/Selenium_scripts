package com.pojo;

import com.google.gson.Gson;

public class DeCouplingRunner {
	public static void main(String[] args) {
		String baseUrl = "http://139.59.91.96:3000", endpoint = "/v1/login", verb = "post", header = "application/json",
				body = "";
		
		CustomerAddressPOJO customerAddress = new CustomerAddressPOJO("101", "ABC", "MG Road", "inorbit", "abc",
				"400104", "india", "Maharashtra");
		
		CustomerPOJO customer = new CustomerPOJO("amit", "nair", "4354654634", "4354654634", "amit@gmail.com", "");

		
		CustomerProductPOJO customerProductPOJO = new CustomerProductPOJO("2022-05-03T18:30:00.000Z", "11111111111111",
				"11111111111111", "11111111111111", "2022-05-03T18:30:00.000Z", 1, 1);
//Array of non primitive Data Type and each index now acts as a reference variable for the Non Primitive Class
		ProblemPOJO[] problems = new ProblemPOJO[3];
		problems[0] = new ProblemPOJO(1, " battery low");
		problems[1] = new ProblemPOJO(2, " display not working");
		problems[2] = new ProblemPOJO(3, "headphone jack not working");
//Inject the dependencies
		IBody jobPojo = new CreateJobPOJO(0, 2, 1, 1, customer, customerAddress, customerProductPOJO, problems);
		
		
		makeRequest(baseUrl, endpoint, verb, header, jobPojo);
	}

	private static void makeRequest(String baseUrl, String endpoint, String verb, String header, IBody body) {
		// TODO Auto-generated method stub
		System.out.println("Making api request");
		// Future RA code
		System.out.println("baseurl " + baseUrl);
		System.out.println("endpoint " + endpoint);
		System.out.println("verb " + verb);
		System.out.println("header " + header);
		System.out.println("body " + body.toJson());

	}

}
