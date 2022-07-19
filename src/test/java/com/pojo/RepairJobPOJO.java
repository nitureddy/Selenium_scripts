package com.pojo;

public class RepairJobPOJO {
	
	private int job_id;

	public RepairJobPOJO(int job_id) {
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
		return "RepairJobPojo [job_id=" + job_id + "]";
	}
	
	
	

}
