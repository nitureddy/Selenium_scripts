package com.api.tests;

import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.constants.Httpverbs;
import com.api.pojo.*;
import com.utils.HelperAPI;
import com.utils.TestUtils;

public final class PhoenixInwarrantyFlow {

	private String token;
	private CreateNewJob createdjob;
	private String fduserdetail, supuserdetail, enguserdetail, qcuserdetail;
	private Response Newjob;
	private int fdcount, supcount, engcount, qccount;
	public static String JobId;
	public static int JobNumber;
	private int NewCount;
	private Response jobsearch;
	private HelperAPI helper = new HelperAPI();
	private HashMap<String, String> credentialsMap = new HashMap<String, String>();

	@BeforeClass(description = "Intializing the baseURL,Random IEMI Number,Problem & Created new Job Object", alwaysRun = true)
	public final void Intialization() {
		baseURI = TestUtils.getProperties("URL");
		Problems[] p1 = new Problems[1];
		String imei = TestUtils.generateIMEI();
		String date = TestUtils.timeStampforJobCreation();
		p1[0] = new Problems(2, "");
		createdjob =  new CreateNewJob(0, 2, 1, 1,
				new Customer("abc", "xyz", "7546567577", "8746567767", "abc@gmail.com",
						"xyz@gmail.com"),
				new CustomerAddress("B11", "Heights", "industrial", "Mumbai", "industrial", "400110", "India",
						"Maharashtra"),
				new CustomerProduct(date, imei, imei, imei, date, 1, 1),
				p1);
	}

	@Test(description = "Verifying FrontDesk Login API Test", groups = {"api", "sanity", "smoke",
			"e2e" }, priority = 1, dataProviderClass = com.dataprovider.Logindataprovider.class, dataProvider = "Get Data form Excel")
	public final void FDLoginAPITest(String userName, String Password, String Role, String Statuscode) {
		
		token = helper
				.request("/v1/login", Httpverbs.POST, new PhoenixLoginCredentialsPOJO(userName, Password),
						new Header("Content-type", "application/json"))
				.then().and().assertThat().statusCode(Integer.parseInt(Statuscode))
				.body(Matchers.containsString("Success")).extract().jsonPath().getString("data.token");
		credentialsMap.put(Role, token);
	}

	@Test(description = "Verifying FrontDesk user_detail Test", groups = { "api","sanity", "e2e" }, priority = 2)
	public final void FDuserdetailTest() {
		Response response = helper.request("/v1/userdetails", Httpverbs.GET,
				new Header("Authorization", credentialsMap.get("fd")));

		fduserdetail = response.then().extract().jsonPath().getString("data.first_name");
		response.then().and().assertThat().statusCode(200).body(Matchers.containsString("Success"));
		Assert.assertEquals(fduserdetail, "fd");
	}

	@Test(description = "Verifying FrontDesk Count Test", groups = { "api", "sanity", "smoke" }, priority = 3)
	public final void FDcountTest() {
		fdcount = helper
				.request("/v1/dashboard/count", Httpverbs.GET, new Header("Authorization", credentialsMap.get("fd")))
				.then().assertThat().statusCode(200).body(Matchers.containsString("Success")).extract().jsonPath()
				.getInt("data[1].count");
	}

	@Test(description = "Verifying FrontDesk Created New Job Test", groups = { "api","sanity", "smoke",
			"e2e" }, priority = 4, dependsOnMethods = {"FDLoginAPITest"})
	public final void FDNewJobTest() {
		Newjob = helper.request("/v1/job/create", Httpverbs.POST, createdjob,
				new Header("Authorization", credentialsMap.get("fd")), new Header("Content-type", "application/json"));
		JobId = Newjob.then().and().body(Matchers.containsString("Job created successfully."))
				.extract().jsonPath().getString("data.job_number");
		JobNumber = Newjob.then().and().assertThat()
				.body(Matchers.containsString("Job created successfully.")).extract().jsonPath().getInt("data.id");
	}

	@Test(description = "Verifying FrontDesk New Count", groups = { "api","sanity", "smoke" }, priority = 5)
	public final void FDNewcountTest() {
		Response response = helper.request("/v1/dashboard/count", Httpverbs.GET,
				new Header("Authorization", credentialsMap.get("fd")));
		NewCount = response.then().and().assertThat().statusCode(200).body(Matchers.containsString("Success")).extract()
				.jsonPath().getInt("data[1].count");
		Assert.assertEquals(fdcount + 1, NewCount);
	}

	@Test(description = "Verifying FrontDesk New Job Search API Test", groups = { "api","smoke", "e2e" }, priority = 6)
	public final void JobSearchAPITest() {
		jobsearch = helper.request("/v1/job/search", Httpverbs.POST, new com.api.pojo.Job_Search(JobId),
				new Header("Authorization", credentialsMap.get("fd")), new Header("Content-type", "application/json"));
		String Job = jobsearch.then().and().assertThat().body(Matchers.containsString("Success"))
				.statusCode(200).extract().jsonPath().getString("data[0].job_number");
		Assert.assertEquals(Job, JobId);

	}

	@Test(description = "Verifying Supervisor user_detail API Test", groups = { "api", "sanity", "e2e" }, priority = 8)
	public final void SupuserdetailTest() {
		helper.clearArrayList();
		Response responses = helper.request("/v1/userdetails", Httpverbs.GET,
				new Header("Authorization", credentialsMap.get("sup")));
		supuserdetail = responses.then().extract().jsonPath().getString("data.first_name");
		responses.then().assertThat().statusCode(200).body(Matchers.containsString("Success"));
		Assert.assertEquals(supuserdetail, "John");
	}

	@Test(description = "Verifying Supervisor Count Test", groups = { "api", "sanity", "smoke" }, priority = 9)
	public final void supcountAPITest() {
		supcount = helper
				.request("/v1/dashboard/count", Httpverbs.GET, new Header("Authorization", credentialsMap.get("sup")))
				.then().and().assertThat().statusCode(200).body(Matchers.containsString("Success"))
				.extract().jsonPath().getInt("data[1].count");
	}

	@Test(description = "Verifying Supervisor Job Assign API Test ", groups = { "api","sanity", "e2e",
			"smoke" }, priority = 10)
	public final void JobAssignTest() {
		helper.request("/v1/engineer/assign", Httpverbs.POST, new SupJobAssignPojo(JobNumber, 2),
				new Header("Authorization", credentialsMap.get("sup")), new Header("Content-type", "application/json"))
				.then().and().assertThat().statusCode(200)
				.body(Matchers.containsString("Engineer assigned successfully"));
	}

	@Test(description = "Verifying Supervisor New Count API Test", groups = { "api","e2e", "sanity", "smoke" }, priority = 11)
	public final void SupNewCountAPITest() {
		int SupNewCount = helper
				.request("/v1/dashboard/count", Httpverbs.GET, new Header("Authorization", credentialsMap.get("sup")))
				.then().and().assertThat().statusCode(200).body(Matchers.containsString("Success"))
				.extract().jsonPath().getInt("data[1].count");
		Assert.assertEquals(supcount + 1, SupNewCount);
	}

	@Test(description = "Verifying Supervisor Job Search API Test", groups = { "smoke", "api" }, priority = 12)
	public final void SupJobSearchTest() {
		Response search = helper.request("/v1/job/search", Httpverbs.POST, new com.api.pojo.Job_Search(JobId),
				new Header("Authorization", credentialsMap.get("sup")));
		String Job = search.then().log().all().and().assertThat().body(Matchers.containsString("Success"))
				.statusCode(200).extract().jsonPath().getString("data[0].job_number");
		Assert.assertEquals(Job, JobId);
	}

	@Test(description = "Verifying Engineer user_detail API Test", groups = { "api", "e2e" }, priority = 14)
	public final void EnguserdetailTest() {
		helper.clearArrayList();
		Response response = helper.request("/v1/userdetails", Httpverbs.GET,
				new Header("Authorization", credentialsMap.get("eng")), new Header("Content-type", "application/json"));
		enguserdetail = response.then().log().all().extract().jsonPath().getString("data.first_name");
		response.then().and().assertThat().statusCode(200).body(Matchers.containsString("Success"));
		Assert.assertEquals(enguserdetail, "Mark");
	}

	@Test(description = "Verifying Engineer Count Test", groups = { "api", "sanity", "smoke" }, priority = 15)
	public final void engcountAPITest() {
		engcount = helper
				.request("/v1/dashboard/count", Httpverbs.GET, new Header("Authorization", credentialsMap.get("eng")))
				.then().log().all().and().assertThat().statusCode(200).body(Matchers.containsString("Success"))
				.extract().jsonPath().getInt("data[1].count");
	}

	@Test(description = "Verifying Engineer Job Repair completed API Test", groups = { "api", "e2e",
			"smoke" }, priority = 16)
	public final void JobRepairTest() {
		Problems[] P1 = new Problems[1];
		P1[0] = new Problems(4, "solved");
		helper.request("/v1/engineer/repaircomplete", Httpverbs.POST, new JobRepairPojo(JobNumber, P1),
				new Header("Authorization", credentialsMap.get("eng")), new Header("Content-type", "application/json"))
				.then().log().all().and().assertThat().statusCode(200)
				.body(Matchers.containsString("Repair successful."));
	}

	@Test(description = "Verifying Engineer New Count API Test", groups = { "api","e2e", "sanity", "smoke" }, priority = 17)
	public final void EngNewCountAPITest() {
		int engnewcount = helper
				.request("/v1/dashboard/count", Httpverbs.GET, new Header("Authorization", credentialsMap.get("eng")))
				.then().log().all().and().assertThat().statusCode(200).body(Matchers.containsString("Success"))
				.extract().jsonPath().getInt("data[1].count");
		Assert.assertEquals(engcount + 1, engnewcount);
	}

	@Test(description = "Verifying Engineer Job Search API Test", groups = { "smoke", "api" }, priority = 18)
	public final void EngJobSearchTest() {
		Response search = helper.request("/v1/job/search", Httpverbs.POST, new com.api.pojo.Job_Search(JobId),
				new Header("Authorization", credentialsMap.get("eng")), new Header("Content-type", "application/json"));
		String Job = search.then().log().all().and().assertThat().body(Matchers.containsString("Success"))
				.statusCode(200).extract().jsonPath().getString("data[0].job_number");
		Assert.assertEquals(Job, JobId);
	}

	@Test(description = "Verifying Qc user_detail API Test", groups = { "api", "e2e" }, priority = 20)
	public final void QcUserDetailTest() {
		helper.clearArrayList();
		Response response = helper.request("/v1/userdetails", Httpverbs.GET,
				new Header("Authorization", credentialsMap.get("qc")));
		qcuserdetail = response.then().log().all().extract().jsonPath().getString("data.first_name");
		response.then().and().assertThat().statusCode(200).body(Matchers.containsString("Success"));
		Assert.assertEquals(qcuserdetail, "qc");
	}

	@Test(description = "Verifying Qc Count Test", groups = { "api", "sanity", "smoke" }, priority = 21)
	public final void QcCountAPITest() {
		qccount = helper
				.request("/v1/dashboard/count", Httpverbs.GET, new Header("Authorization", credentialsMap.get("qc")))
				.then().log().all().and().assertThat().statusCode(200).body(Matchers.containsString("Success"))
				.extract().jsonPath().getInt("data[1].count");
	}

	@Test(description = "Verifying Qc Job Completed API Test", groups = { "api", "e2e", "smoke" }, priority = 22)
	public final void QcJobCompletedTest() {
		helper.request("/v1/qc", Httpverbs.POST, new JobCompletedPojo(JobNumber),
				new Header("Authorization", credentialsMap.get("qc")), new Header("Content-type", "application/json"))
				.then().log().all().and().assertThat().statusCode(200)
				.body(Matchers.containsString("QC completed successfully"));
	}

	@Test(description = "Verifying Qc New Count API Test", groups = { "api","e2e", "sanity", "smoke" }, priority = 23)
	public final void QcNewCountAPITest() {
		int qcnewcount = helper
				.request("/v1/dashboard/count", Httpverbs.GET, new Header("Authorization", credentialsMap.get("qc")))
				.then().log().all().and().assertThat().statusCode(200).body(Matchers.containsString("Success"))
				.extract().jsonPath().getInt("data[1].count");
		Assert.assertEquals(qccount + 1, qcnewcount);
	}

	@Test(description = "Verifying Qc Job Search API Test", groups = { "smoke", "api" }, priority = 24)
	public final void QcJobSearchTest() {
		Response search = helper.request("/v1/job/search", Httpverbs.POST, new com.api.pojo.Job_Search(JobId),
				new Header("Authorization", credentialsMap.get("qc")), new Header("Content-type", "application/json"));
		String Job = search.then().log().all().and().assertThat().body(Matchers.containsString("Success"))
				.statusCode(200).extract().jsonPath().getString("data[0].job_number");
		Assert.assertEquals(Job, JobId);
	}

}
