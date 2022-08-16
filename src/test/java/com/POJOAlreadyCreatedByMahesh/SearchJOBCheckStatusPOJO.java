package com.POJOAlreadyCreatedByMahesh;

import com.google.gson.Gson;

public class SearchJOBCheckStatusPOJO implements IBody {
	private String searchText;

	public SearchJOBCheckStatusPOJO(String searchText) {
		super();
		this.searchText = searchText;
	}


	public String getJob_number() {
		return searchText;
	}

	public void setJob_number(String searchText) {
		this.searchText = searchText;
	}

	
	@Override
	public String toString() {
		return "SearchJOBCheckStatus [searchText=" + searchText + "]";
	}
	
	public String toJson() {
		SearchJOBCheckStatusPOJO srchJob = new SearchJOBCheckStatusPOJO(searchText);
		Gson gson = new Gson();
		return gson.toJson(srchJob);
		
	}

}
