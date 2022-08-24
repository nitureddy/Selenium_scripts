package com.pojo;

import java.util.Arrays;

import com.google.gson.Gson;

public final class CreateJobPOJO implements IBody {
	private int mst_service_location_id;
	private int mst_platform_id;
	private int mst_warrenty_status_id;
	private int mst_oem_id;

	private CustomerPOJO customer;
	private CustomerAddressPOJO customer_address;
	private CustomerProductPOJO customer_product;
	private ProblemPOJO[] problems;

	public CreateJobPOJO(int mst_service_location_id, int mst_platform_id, int mst_warrenty_status_id, int mst_oem_id,
			CustomerPOJO customer, CustomerAddressPOJO customer_address, CustomerProductPOJO customer_product,
			ProblemPOJO[] problems) {
		super();
		this.mst_service_location_id = mst_service_location_id;
		this.mst_platform_id = mst_platform_id;
		this.mst_warrenty_status_id = mst_warrenty_status_id;
		this.mst_oem_id = mst_oem_id;
		this.customer = customer;
		this.customer_address = customer_address;
		this.customer_product = customer_product;
		this.problems = problems;
	}

	public CustomerPOJO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerPOJO customer) {
		this.customer = customer;
	}

	public CustomerAddressPOJO getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(CustomerAddressPOJO customer_address) {
		this.customer_address = customer_address;
	}

	public CustomerProductPOJO getCustomer_product() {
		return customer_product;
	}

	public void setCustomer_product(CustomerProductPOJO customer_product) {
		this.customer_product = customer_product;
	}

	public ProblemPOJO[] getProblems() {
		return problems;
	}

	public void setProblems(ProblemPOJO[] problems) {
		this.problems = problems;
	}

	public int getMst_service_location_id() {
		return mst_service_location_id;
	}

	public void setMst_service_location_id(int mst_service_location_id) {
		this.mst_service_location_id = mst_service_location_id;
	}

	public int getMst_platform_id() {
		return mst_platform_id;
	}

	public void setMst_platform_id(int mst_platform_id) {
		this.mst_platform_id = mst_platform_id;
	}

	public int getMst_warrenty_status_id() {
		return mst_warrenty_status_id;
	}

	public void setMst_warrenty_status_id(int mst_warrenty_status_id) {
		this.mst_warrenty_status_id = mst_warrenty_status_id;
	}

	public int getMst_oem_id() {
		return mst_oem_id;
	}

	public void setMst_oem_id(int mst_oem_id) {
		this.mst_oem_id = mst_oem_id;
	}

	@Override
	public String toString() {
		return "CreateJobPOJO [mst_service_location_id=" + mst_service_location_id + ", mst_platform_id="
				+ mst_platform_id + ", mst_warrenty_status_id=" + mst_warrenty_status_id + ", mst_oem_id=" + mst_oem_id
				+ ", customer=" + customer + ", customer_address=" + customer_address + ", customer_product="
				+ customer_product + ", problems=" + Arrays.toString(problems) + "]";
	}

	public String toJson() {
		// TODO Auto-generated method stub
		CreateJobPOJO c = new CreateJobPOJO(mst_service_location_id, mst_platform_id, mst_warrenty_status_id,
				mst_oem_id, customer, customer_address, customer_product, problems);
		Gson gson = new Gson();
		String data = gson.toJson(c);
		return data;

	}

}
