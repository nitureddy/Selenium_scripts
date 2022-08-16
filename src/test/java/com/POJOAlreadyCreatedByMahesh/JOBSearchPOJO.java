package com.POJOAlreadyCreatedByMahesh;

import com.google.gson.Gson;

public class JOBSearchPOJO implements IBody{

	private String searchText;
	
	public JOBSearchPOJO(String searchText) {
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
		return "JOBSearchPOJO [searchText=" + searchText + "]";
	}

	public String toJson() {
		JOBSearchPOJO jobserch = new JOBSearchPOJO(searchText);
		Gson gson = new Gson();
		return gson.toJson(jobserch);
		
	}
	
}
