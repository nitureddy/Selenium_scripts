package com.db;

public class Runner {
	public static void main(String[] args) {

		MySingleton m = MySingleton.getInstance();

		m.x();

		System.out.println(m);

		MySingleton m1 = MySingleton.getInstance();

		m1.x();

		System.out.println(m1);

		MySingleton m2 = MySingleton.getInstance();

		m2.x();

		System.out.println(m2);

		
	}
}
