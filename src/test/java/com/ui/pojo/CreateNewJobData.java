/**
 * 
 */
package com.ui.pojo;

import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;

/**
 * @author Jatin
 *
 */
public class CreateNewJobData {

	private DeviceDetailsPOJO deviceDetails;
	private ProblemDetailsPOJO problemDetails;
	private Customer customerInfo;
	private CustomerAddress customerAddressInfo;

	public CreateNewJobData(DeviceDetailsPOJO deviceDetails, ProblemDetailsPOJO problemDetails, Customer customerInfo,
			CustomerAddress customerAddressInfo) {
		super();
		this.deviceDetails = deviceDetails;
		this.problemDetails = problemDetails;
		this.customerInfo = customerInfo;
		this.customerAddressInfo = customerAddressInfo;
	}

	public DeviceDetailsPOJO getDeviceDetails() {
		return deviceDetails;
	}

	public void setDeviceDetails(DeviceDetailsPOJO deviceDetails) {
		this.deviceDetails = deviceDetails;
	}

	public ProblemDetailsPOJO getProblemDetails() {
		return problemDetails;
	}

	public void setProblemDetails(ProblemDetailsPOJO problemDetails) {
		this.problemDetails = problemDetails;
	}

	public Customer getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(Customer customerInfo) {
		this.customerInfo = customerInfo;
	}

	public CustomerAddress getCustomerAddressInfo() {
		return customerAddressInfo;
	}

	public void setCustomerAddressInfo(CustomerAddress customerAddressInfo) {
		this.customerAddressInfo = customerAddressInfo;
	}

	@Override
	public String toString() {
		return "CreateNewJobData [deviceDetails=" + deviceDetails + ", problemDetails=" + problemDetails
				+ ", customerInfo=" + customerInfo + ", customerAddressInfo=" + customerAddressInfo + "]";
	}

}
