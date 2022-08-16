package com.InwarrantyResponsePOJO;

public class CreateJobResponseData {
	private int id;
	private int mst_service_location_id;
	private int mst_warrenty_status_id;
	private int mst_oem_id;
	private int tr_customer_id;
	private String tr_customer_product_id;
	private String job_number;
	public CreateJobResponseData(int id, int mst_service_location_id, int mst_warrenty_status_id, int mst_oem_id,
			int tr_customer_id, String tr_customer_product_id, String job_number) {
		super();
		this.id = id;
		this.mst_service_location_id = mst_service_location_id;
		this.mst_warrenty_status_id = mst_warrenty_status_id;
		this.mst_oem_id = mst_oem_id;
		this.tr_customer_id = tr_customer_id;
		this.tr_customer_product_id = tr_customer_product_id;
		this.job_number = job_number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMst_service_location_id() {
		return mst_service_location_id;
	}
	public void setMst_service_location_id(int mst_service_location_id) {
		this.mst_service_location_id = mst_service_location_id;
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
	public int getTr_customer_id() {
		return tr_customer_id;
	}
	public void setTr_customer_id(int tr_customer_id) {
		this.tr_customer_id = tr_customer_id;
	}
	public String getTr_customer_product_id() {
		return tr_customer_product_id;
	}
	public void setTr_customer_product_id(String tr_customer_product_id) {
		this.tr_customer_product_id = tr_customer_product_id;
	}
	public String getJob_number() {
		return job_number;
	}
	public void setJob_number(String job_number) {
		this.job_number = job_number;
	}
	@Override
	public String toString() {
		return "CreateJobResponseData [id=" + id + ", mst_service_location_id=" + mst_service_location_id
				+ ", mst_warrenty_status_id=" + mst_warrenty_status_id + ", mst_oem_id=" + mst_oem_id
				+ ", tr_customer_id=" + tr_customer_id + ", tr_customer_product_id=" + tr_customer_product_id
				+ ", job_number=" + job_number + "]";
	}
	

}
