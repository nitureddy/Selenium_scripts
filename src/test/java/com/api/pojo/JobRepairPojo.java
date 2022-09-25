package com.api.pojo;

import java.util.Arrays;

import com.google.gson.Gson;

public final class JobRepairPojo implements IBodyJson {
	private int job_id;
	Problems[] problems;
	
	public JobRepairPojo(int job_id, Problems[] problems) {
		super();
		this.job_id = job_id;
		this.problems = problems;
	}

	@Override
	public String toString() {
		return "Job_repair_Pojo [job_id=" + job_id + ", problems=" + Arrays.toString(problems) + "]";
	}

	public String toJson() {
		JobRepairPojo R = new JobRepairPojo(job_id, problems);
		Gson g = new Gson();
		return g.toJson(R);
	}

	
}
