package com.utils;

import com.pojo.CreateJobPOJO;
import com.pojo.CustomerAddressPOJO;
import com.pojo.CustomerPOJO;
import com.pojo.CustomerProductPOJO;
import com.pojo.ProblemPOJO;

public class TestUtil {

	public static CreateJobPOJO getCreateJobData() {
		// String imei = createIMEINumber();
		CustomerPOJO customerInfoPOJO = new CustomerPOJO("vaibhav", "Kalshetti", "9705593183", "970555445",
				"vaibhav@gmail.com", "");
		CustomerAddressPOJO customerAddressPOJO = new CustomerAddressPOJO("101", "abc apt", "street name1",
				"near ayyapa temple", "kukatpally", "500072", "India", "Andhra Pradesh");
		CustomerProductPOJO customerProductPOJO = new CustomerProductPOJO("2022-04-05T18:30:00.000Z", "12344567123412",
				"12344567123412", "12344567123412", "2022-04-05T18:30:00.000Z", 1, 2);
		ProblemPOJO[] problems = new ProblemPOJO[3];
		problems[0] = new ProblemPOJO(1, "battery drains quickly");
		problems[1] = new ProblemPOJO(4, "camera not working");
		problems[2] = new ProblemPOJO(3, "app crashes");

		CreateJobPOJO createJobPOJO = new CreateJobPOJO(0, 2, 1, 1, customerInfoPOJO, customerAddressPOJO,
				customerProductPOJO, problems);
		System.out.println(createJobPOJO.toJson());
		return createJobPOJO;
	}

	public String createIMEINumber() {
		// Generate a random 14 digit number using Java
		return null;
	}
}
