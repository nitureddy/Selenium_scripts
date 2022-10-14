/**
 * 
 */
package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.api.pojo.CreateNewJob;
import com.ui.pojo.CreateNewJobData;
import com.utils.BrowserUtility;
import com.utils.TestUtils;

/**
 * @author Jatin
 *
 */
public class CreateJobPage extends BrowserUtility {
	private static final By OEM_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder=\"Select OEM\"]");
	private static final By PRODUCT_NAME_DROPDOWN_LOCATOR = By
			.xpath("//span[contains(text(),'Select Product name')]/../../..");
	private static final By MODEL_NAME_DROPDOWN_LOCATOR = By
			.xpath("//mat-select[contains(@placeholder,'Select Model name')]");
	private static final By IMEI_TEXT_BOX_LOCATOR = By.xpath("//input[contains(@data-placeholder,'0123456789')]");
	private static final By PURCHASE_DATE_BOX_LOCATOR = By.xpath("//input[@data-placeholder='dd/mm/yyyy']");
	private static final By WARRANTY_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select Warranty Status']");
	private static final By PROBLEM_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select Problem']");
	private static final By REMARK_TEXT_BOX_LOCATOR = By.xpath("//input[@placeholder='Remarks']");
	private static final By FIRST_NAME_TEXT_BOX_LOCATOR = By.xpath("//input[@data-placeholder='First Name']");
	private static final By LAST_NAME_TEXT_BOX_LOCATOR = By.xpath("//input[@data-placeholder='Last Name']");
	private static final By CONTACT_TEXT_BOX_LOCATOR = By.xpath("//input[@data-placeholder='Contact No.']");
	private static final By EMAIL_TEXT_BOX_LOCATOR = By.xpath("//input[@data-placeholder='Email Id.']");
	private static final By FLAT_NUMBER_TEXT_BOX_LOCATOR = By.xpath("//input[@data-placeholder='Flat/Society No.']");
	private static final By APARTMENT_NAME_TEXT_BOX_LOCATOR = By.xpath("//input[@data-placeholder='Apartment Name']");
	private static final By LANDMARK_TEXT_BOX_LOCATOR = By.xpath("//input[@data-placeholder='Choose a Landmark']");
	private static final By STREET_NAME_TEXT_BOX_LOCATOR = By.xpath("//input[@data-placeholder='Street Name.']");
	private static final By AREA_NAME_TEXT_BOX_LOCATOR = By.xpath("//input[@data-placeholder='Area']");
	private static final By STATE_NAME_TEXT_BOX_LOCATOR = By.xpath("//input[@data-placeholder='Select State']");
	private static final By PIN_CODE_TEXT_BOX_LOCATOR = By.xpath("//input[@data-placeholder='Pincode']");
	private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Submit')]/..");
	private static final By JOB_TOAST_LOCATOR = By.xpath("	//span[contains(text(),\"Job created successfully\")]");

	/**
	 * @param wd
	 */
	public CreateJobPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}

	public String createJob(CreateNewJobData createJobData) {
		enterText(IMEI_TEXT_BOX_LOCATOR, createJobData.getDeviceDetails().getImeiName());
		selectFromDropDown("oem", createJobData.getDeviceDetails().getOemName());
		selectFromDropDown("id", createJobData.getProblemDetails().getProblem());
		selectFromDropDown("productName", createJobData.getDeviceDetails().getProdName());
		selectFromDropDown("warrantyStatus", createJobData.getDeviceDetails().getWarrantyStatus());
		selectFromDropDown("modelName", createJobData.getDeviceDetails().getModelName());
		enterText(PURCHASE_DATE_BOX_LOCATOR, createJobData.getDeviceDetails().getDop());
		enterText(REMARK_TEXT_BOX_LOCATOR, createJobData.getProblemDetails().getRemark());
		enterText(FIRST_NAME_TEXT_BOX_LOCATOR, createJobData.getCustomerInfo().getFirst_name());
		enterText(LAST_NAME_TEXT_BOX_LOCATOR, createJobData.getCustomerInfo().getLast_name());
		enterText(CONTACT_TEXT_BOX_LOCATOR, createJobData.getCustomerInfo().getMobile_number());
		enterText(AREA_NAME_TEXT_BOX_LOCATOR, createJobData.getCustomerAddressInfo().getArea());
		enterText(PIN_CODE_TEXT_BOX_LOCATOR, createJobData.getCustomerAddressInfo().getPincode());
		enterText(STREET_NAME_TEXT_BOX_LOCATOR, createJobData.getCustomerAddressInfo().getStreet_name());
		enterText(FLAT_NUMBER_TEXT_BOX_LOCATOR, createJobData.getCustomerAddressInfo().getFlat_number());
		enterText(EMAIL_TEXT_BOX_LOCATOR, createJobData.getCustomerInfo().getEmail_id());
		enterText(APARTMENT_NAME_TEXT_BOX_LOCATOR, createJobData.getCustomerAddressInfo().getApartment_name());
		enterText(LANDMARK_TEXT_BOX_LOCATOR, createJobData.getCustomerAddressInfo().getLandmark());
		enterText(STATE_NAME_TEXT_BOX_LOCATOR, createJobData.getCustomerAddressInfo().getState());
		clickOn(SUBMIT_BUTTON_LOCATOR);
		System.out.println(TestUtils.getJobNumberFromToastMsg(getVisibleText(JOB_TOAST_LOCATOR)));
		return TestUtils.getJobNumberFromToastMsg(getVisibleText(JOB_TOAST_LOCATOR));
	}

}
