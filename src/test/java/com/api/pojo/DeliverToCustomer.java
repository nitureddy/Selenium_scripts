package com.api.pojo;

import com.google.gson.Gson;

public class DeliverToCustomer implements IBodyJson {

	
int job_id;
	

	public DeliverToCustomer(int job_id) {
		super();
		this.job_id = job_id;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	@Override
	public String toString() {
		return "QCcomplete [job_id=" + job_id + "]";
	}
	
	
	public String toJson() {
		
		DeliverToCustomer DC = new DeliverToCustomer(job_id);
		Gson g = new Gson();
		String data1 = g.toJson(DC);
		return data1;
}
	
}
