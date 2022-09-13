package com.pojo;

import com.google.gson.Gson;

public class JobSearchPOJO implements IBody {

	private String searchText;

	public JobSearchPOJO(String searchText) {
		super();
		this.searchText =   searchText;
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
		JobSearchPOJO j = new JobSearchPOJO("JOB_"+searchText);
		System.out.println("*************"+searchText);
		Gson g = new Gson();
		System.out.println(g.toJson(j));
		return g.toJson(j);
	}

}
