package com.faker;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerExample {
	public static void main(String[] args) {

		Faker faker = new Faker(Locale.ENGLISH);
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().lastName());
		System.out.println(faker.address().buildingNumber());
		System.out.println(faker.address().streetAddress());
		System.out.println(faker.phoneNumber().cellPhone());


	}
}
