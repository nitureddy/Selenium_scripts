package com.pojo;

import com.google.gson.Gson;

public class Runner {
	public static void main(String[] args) {
//Create the reference and objects for pojos
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
		CreateJobPOJO jobPojo = new CreateJobPOJO(0, 2, 1, 1, customer, customerAddress, customerProductPOJO, problems);
		
// Gson is used to convert POJO objec to JSON Object: Serialization
		
		Gson gson = new Gson();
		String data = gson.toJson(jobPojo);

		System.out.println(jobPojo);
		System.out.println(data);

	}
}
