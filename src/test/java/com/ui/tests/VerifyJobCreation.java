/**
 * 
 */
package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.day2.Browser;
import com.ui.pages.LoginPage;
import com.ui.pojo.CreateNewJobData;
import com.ui.pojo.FDDashBoardTablePOJO;
import com.utils.TestUtils;

import static com.utils.TestUtils.*;

import java.util.List;

/**
 * @author Jatin
 *
 */
public class VerifyJobCreation {
	private LoginPage loginPage;
	private CreateNewJobData createNewJobData;
	private String job_number="JOB_18372";

	@BeforeMethod(description = "setup of the Browser")
	public void setup() {
		loginPage = new LoginPage(Browser.CHROME);
		createNewJobData = getCreateJobUIData();
	}

//	@Test
//	public void createJobTest() {
//		job_number = loginPage.doLoginWith("iamfd", "password").goToCreateJobPage().createJob(createNewJobData);
//		System.out.println(job_number);
//		// Assert.assertTrue(notNull(job_number));
//	}

	@Test
	public void verifyIftheJobIsPresentInTable() {
		List<FDDashBoardTablePOJO> data = loginPage.doLoginWith("iamfd", "password").getDataFromTable().stream()
				.filter(x -> (x.getJob_Number().equalsIgnoreCase( job_number))).toList();
		System.out.println(data);
	}
}
