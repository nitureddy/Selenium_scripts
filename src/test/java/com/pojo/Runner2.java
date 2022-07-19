package com.pojo;

import com.google.gson.Gson;

public class Runner2 {
	public static void main(String[] args) {

		IBody body = new AssignJobPOJO(0, 101);
		String data = body.toJson();
		System.out.println(data);

		body = new LoginPOJO("iamfd", "password");
		System.out.println(body.toJson());
	}
}
