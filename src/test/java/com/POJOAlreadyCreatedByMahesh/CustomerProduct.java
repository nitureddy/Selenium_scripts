package com.POJOAlreadyCreatedByMahesh;

public class CustomerProduct {
	private String dop;
	private String serial_number;
	private String imei1;
	private String imei2;
	private String popurl;
	private String product_id;
	private String mst_model_id;
	public CustomerProduct(String dop, String serial_number, String imei1, String imei2, String popurl,
			String product_id, String mst_model_id) {
		if(validateSerialNumber(serial_number))
		{
		this.dop = dop;
		this.serial_number = serial_number;
		this.imei1 = imei1;
		this.imei2 = imei2;
		this.popurl = popurl;
		this.product_id = product_id;
		this.mst_model_id = mst_model_id;
		}
		else
		{
			System.out.println("Please enter 14 digit serial Number");
			System.exit(0);
		}
	}
	private boolean validateSerialNumber(String serial_number2) {
		if(serial_number2.length() < 14)
		return false;
		else 
			return true;
	}
	public String getDop() {
		return dop;
	}
	public void setDop(String dop) {
		this.dop = dop;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
	public String getImei1() {
		return imei1;
	}
	public void setImei1(String imei1) {
		this.imei1 = imei1;
	}
	public String getImei2() {
		return imei2;
	}
	public void setImei2(String imei2) {
		this.imei2 = imei2;
	}
	public String getPopurl() {
		return popurl;
	}
	public void setPopurl(String popurl) {
		this.popurl = popurl;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getMst_model_id() {
		return mst_model_id;
	}
	public void setMst_model_id(String mst_model_id) {
		this.mst_model_id = mst_model_id;
	}
	@Override
	public String toString() {
		return "CustomerProduct [dop=" + dop + ", serial_number=" + serial_number + ", imei1=" + imei1 + ", imei2="
				+ imei2 + ", popurl=" + popurl + ", product_id=" + product_id + ", mst_model_id=" + mst_model_id + "]";
	}
	
	

}
