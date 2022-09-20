package com.POJOAlreadyCreatedByMahesh;

import java.util.Arrays;

public class CreatejobPOJO {
	private int mst_service_location_id;
	private int mst_platform_id;
	private int mst_warrenty_status_id;
	private int mst_oem_id;
	private Customer customer;
	private CustomerAddress customer_address;
	private CustomerProduct customer_product;
	public Problems problem[];
	public CreatejobPOJO(int mst_service_location_id, int mst_platform_id, int mst_warrenty_status_id, int mst_oem_id,
			Customer customer, CustomerAddress customer_address, CustomerProduct customer_product, Problems[] problem) {
		
		this.mst_service_location_id = mst_service_location_id;
		this.mst_platform_id = mst_platform_id;
		this.mst_warrenty_status_id = mst_warrenty_status_id;
		this.mst_oem_id = mst_oem_id;
		this.customer = customer;
		this.customer_address = customer_address;
		this.customer_product = customer_product;
		this.problem = problem;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerAddress getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(CustomerAddress customer_address) {
		this.customer_address = customer_address;
	}
	public CustomerProduct getCustomer_product() {
		return customer_product;
	}
	public void setCustomer_product(CustomerProduct customer_product) {
		this.customer_product = customer_product;
	}
	public Problems[] getProblem() {
		return problem;
	}
	public void setProblem(Problems[] problem) {
		this.problem = problem;
	}
	@Override
	public String toString() {
		return "CreatejobPOJO [mst_service_location_id=" + mst_service_location_id + ", mst_platform_id="
				+ mst_platform_id + ", mst_warrenty_status_id=" + mst_warrenty_status_id + ", mst_oem_id=" + mst_oem_id
				+ ", customer=" + customer + ", customer_address=" + customer_address + ", customer_product="
				+ customer_product + ", problem=" + Arrays.toString(problem) + "]";
	}
	
	
	
	
	

}