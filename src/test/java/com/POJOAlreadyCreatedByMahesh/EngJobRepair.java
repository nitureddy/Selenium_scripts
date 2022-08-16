package com.POJOAlreadyCreatedByMahesh;

import java.util.Arrays;

import com.google.gson.Gson;

public class EngJobRepair implements IBody{
	private int job_id;
	Problems problems[];
	public EngJobRepair(int job_id, Problems[] problem) {
		
		this.job_id = job_id;
		this.problems = problem;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public Problems[] getProblem() {
		return problems;
	}
	public void setProblem(Problems[] problem) {
		this.problems = problem;
	}
	@Override
	public String toString() {
		return "EngJobRepair [job_id=" + job_id + ", problem=" + Arrays.toString(problems) + "]";
	}
	public String toJson() {
		EngJobRepair jobRepair = new EngJobRepair(job_id, problems);
		Gson gson = new Gson();
		return gson.toJson(jobRepair);
		
	}
	
		

}
