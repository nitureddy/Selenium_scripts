package com.POJOAlreadyCreatedByMahesh;

import com.google.gson.Gson;

public class QCRejectFlow implements IBody {
	private int job_id;

	public QCRejectFlow(int job_id) {
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
		return "QCRejectFlow [job_id=" + job_id + "]";
	}

	public String toJson() {
		QCRejectFlow qcreject = new QCRejectFlow(job_id);
		Gson gson = new Gson();
		return gson.toJson(qcreject);
		
	}
	

}
