package com.api.pojo;

import com.google.gson.Gson;

public final class Job_Search implements IBodyJson{
	private String searchText;

	public Job_Search(String searchText) {
		super();
		this.searchText = searchText;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	@Override
	public String toString() {
		return "Job_Search [searchText=" + searchText + "]";
	}

	public String toJson() {
		Job_Search J = new Job_Search(searchText);
		Gson g = new Gson();
		return g.toJson(J);
	}
	
	

}
