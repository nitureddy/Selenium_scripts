/**
 * 
 */
package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.LoginPage;
import com.ui.pojo.CreateNewJobData;
import com.ui.pojo.FDDashBoardTablePOJO;
import com.utils.Browser;
import com.utils.TestUtils;

import static com.utils.TestUtils.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jatin
 *
 */
public class VerifyJobCreation {
	private LoginPage loginPage;
	private CreateNewJobData createNewJobData;
	private String job_number = "JOB_18372";

	@BeforeMethod(description = "setup of the Browser")
	public void setup() {
		loginPage = new LoginPage(Browser.CHROME);
		createNewJobData = getCreateJobUIData();
	}

	@Test(groups = {"sanity"})
	public void createJobTest() {
		job_number = loginPage.doLoginWith("iamfd", "password").goToCreateJobPage().createJob(createNewJobData);
		System.out.println(job_number);
		Assert.assertTrue(notNull(job_number));
	}

	@Test
	public void verifyIftheJobIsPresentInTable() {

		Assert.assertTrue(loginPage.doLoginWith("iamfd", "password").getDataFromTheFDTable().checkIFJobIsPresentInTable(job_number));
	}
}
