package com.api.pojo;

import com.google.gson.Gson;

public final class CustomerAddress implements IBodyJson{
	private String flat_number;
	private String apartment_name;
	private String street_name;
	private String landmark;
	private String area;
	private String pincode;
	private String country;
	private String state;
	
	public CustomerAddress(String flat_number, String apartment_name, String street_name, String landmark, String area,
			String pincode, String country, String state) {
		super();
		this.flat_number = flat_number;
		this.apartment_name = apartment_name;
		this.street_name = street_name;
		this.landmark = landmark;
		this.area = area;
		this.pincode = pincode;
		this.country = country;
		this.state = state;
	}

	
 @Override
	public String toString() {
		return "customer_address [flat_number=" + flat_number + ", apartment_name=" + apartment_name + ", street_name="
				+ street_name + ", landmark=" + landmark + ", area=" + area + ", pincode=" + pincode + ", country="
				+ country + ", state=" + state + "]";
	}


public String toJson() {
	 CustomerAddress d = new CustomerAddress(flat_number, apartment_name, street_name, landmark, area, pincode, country, state);
	 Gson g = new Gson();
	 return g.toJson(d);
	 
 }
	
}
