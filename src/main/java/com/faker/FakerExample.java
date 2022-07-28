package com.faker;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerExample {
	public static void main(String[] args) {
//https://java-faker.herokuapp.com/
		Faker faker = new Faker(Locale.ENGLISH);
	
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().lastName());
		System.out.println(faker.internet().emailAddress());

		System.out.println(faker.address().buildingNumber());
		System.out.println(faker.address().streetAddress());
		System.out.println(faker.phoneNumber().cellPhone());
		System.out.println(faker.numerify("A############B"));

	}
}
