package com.InwarrantyResponsePOJO;



public class DashboardCount {
	private String message;
	private DashboardData data[];
	public DashboardCount(String message, DashboardData[] data) {
		super();
		this.message = message;
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public DashboardData[] getData() {
		return data;
	}
	public void setData(DashboardData[] data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "DashboardCount [message=" + message + ", data=" + data + "]";
	}
	

}
