package com.api.pojo;

import com.google.gson.Gson;

public final class JobCompletedPojo implements IBodyJson {
	private int job_id;

	public JobCompletedPojo(int job_id) {
		super();
		this.job_id = job_id;
	}

	@Override
	public String toString() {
		return "JobCompletedPojo [job_id=" + job_id + "]";
	}

	public String toJson() {
		JobCompletedPojo R = new JobCompletedPojo(job_id);
		Gson g = new Gson();
		return g.toJson(R);
	}

}
