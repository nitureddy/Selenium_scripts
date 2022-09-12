package com.pojo;

import com.google.gson.Gson;

public class JobSearchPOJO implements IBody {

	private String searchText;

	public JobSearchPOJO(String searchText) {
		super();
		this.searchText = "JOB_" + searchText;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	@Override
	public String toString() {
		return "JobSearchPOJO [searchText=" + searchText + "]";
	}

	public String toJson() {
		// TODO Auto-generated method stub
		JobSearchPOJO j = new JobSearchPOJO(searchText);
		Gson g = new Gson();
		return g.toJson(j);
	}

}
