package com.pojo;

public class JobSearchPOJO {

	private int searchText;

	public JobSearchPOJO(int searchText) {
		super();
		this.searchText = searchText;
	}

	public int getSearchText() {
		return searchText;
	}

	public void setSearchText(int searchText) {
		this.searchText = searchText;
	}

	@Override
	public String toString() {
		return "JobSearchPOJO [searchText=" + searchText + "]";
	}
	
	
	
}
