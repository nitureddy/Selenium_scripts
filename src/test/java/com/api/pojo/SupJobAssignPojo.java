package com.api.pojo;

import com.google.gson.Gson;

public final class SupJobAssignPojo implements IBodyJson{
	private int job_id;
	private int engineer_id;
	
	public SupJobAssignPojo(int job_id, int engineer_id) {
		super();
		this.job_id = job_id;
		this.engineer_id = engineer_id;
	}


	@Override
	public String toString() {
		return "Sup_Job_Assign_Pojo [job_id=" + job_id + ", engineer_id=" + engineer_id + "]";
	}


	public String toJson() {
		SupJobAssignPojo S = new SupJobAssignPojo(job_id, engineer_id);
		Gson g = new Gson();
	    return g.toJson(S);
	}
	
	

}
