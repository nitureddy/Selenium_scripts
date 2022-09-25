package com.api.pojo;

import com.google.gson.Gson;

public final class CreateNewJob implements IBodyJson {
	private int mst_service_location_id;
    private int mst_platform_id;
    private int mst_warrenty_status_id;
    private int mst_oem_id;
    Customer customer;
	CustomerAddress customer_address;
	CustomerProduct customer_product;
	Problems[] problems;
	
	
	public CreateNewJob(int mst_service_location_id, int mst_platform_id, int mst_warrenty_status_id, int mst_oem_id,
			Customer customer, CustomerAddress customer_address, CustomerProduct customer_product,
			Problems[] problems) {
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

//
//	@Override
//	public String toString() {
//		return "Create_Job [mst_service_location_id=" + mst_service_location_id + ", mst_platform_id=" + mst_platform_id
//				+ ", mst_warrenty_status_id=" + mst_warrenty_status_id + ", mst_oem_id=" + mst_oem_id + ", customer="
//				+ customer + ", customer_address= " + customer_address + ", customer_product=" + customer_product
//				+ ", problems=" + Arrays.toString(problems) + "]";
//	}


	public String toJson() {
		CreateNewJob C = new CreateNewJob(mst_service_location_id, mst_platform_id, mst_warrenty_status_id, mst_oem_id, customer, customer_address, customer_product, problems);
		 Gson g = new Gson();
		 return g.toJson(C);
	}
	}