/**
 * 
 */
package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.runner.Runner;
import com.ui.pages.LoginPage;
import com.ui.pojo.CreateNewJobData;
import com.ui.pojo.FDDashBoardTablePOJO;
import com.utils.Browser;
import com.utils.Machine;
import com.utils.TestUtils;

import static com.utils.TestUtils.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jatin
 *
 */
public class VerifyJobCreation2 {
	private LoginPage loginPage;
	private CreateNewJobData createNewJobData;
	private String job_number = "JOB_18372";

	@BeforeMethod(description = "setup of the Browser", alwaysRun = true)
	public void setup() {
		loginPage = new LoginPage(Browser.CHROME, Runner.m);
		createNewJobData = getCreateJobUIData();
	}

	@Test(groups = { "sanity", "e2e", "smoke" })
	public void createJobTest() {
		job_number = loginPage.doLoginWith("iamfd", "password").goToCreateJobPage().createJob(createNewJobData);
		System.out.println(job_number);
		Assert.assertTrue(notNull(job_number));
	}

}
