package com.utils;

import java.util.ArrayList;

import com.api.constants.Httpverbs;
import com.api.pojo.IBodyJson;

import static io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public final class HelperAPI {
	Response response;
	ArrayList<Header> headerList = new ArrayList<Header>();

	public Response request(String endpoint, String httpverbs, IBodyJson body, Header...headers ) {
		for (Header myheader : headers) {
			headerList.add(myheader);
		}
		if (httpverbs.equalsIgnoreCase("post")) {
			return given().when().headers(new Headers(headerList)).and().body(body.toJson()).and().post(endpoint);
		} else if (httpverbs.equalsIgnoreCase("get")) {
			return given().when().headers(new Headers(headerList)).and().get(endpoint);
		} else if (httpverbs.equalsIgnoreCase("delete")) {
			return given().when().headers(new Headers(headerList)).and().delete(endpoint);
		} else if (httpverbs.equalsIgnoreCase("put")) {
			return given().when().headers(new Headers(headerList)).and().body(body.toJson()).and().put(endpoint);
		} else
			return null;

	}

	public Response request(String endpoint, Httpverbs httpverbs, IBodyJson body, Header... headers) {
		for (Header myheader : headers) {
			headerList.add(myheader);
		}
		if (httpverbs == Httpverbs.POST) {
			return given().when().headers(new Headers(headerList)).and().body(body.toJson()).and().post(endpoint);
		} else if (httpverbs == Httpverbs.PUT) {
			return given().when().headers(new Headers(headerList)).and().body(body.toJson()).and().put(endpoint);
		} else
			return null;
	}

	public Response request(String endpoint, Httpverbs httpverbs, Header... headers) {
		for (Header myheader : headers) {
			headerList.add(myheader);
		}
		if (httpverbs == Httpverbs.GET) {
			return given().when().headers(new Headers(headerList)).and().get(endpoint);
		} else if (httpverbs == Httpverbs.DELETE) {
			return given().when().headers(new Headers(headerList)).and().delete(endpoint);
		} else
			return null;
	}

	public void clearArrayList() {
		headerList.removeAll(headerList);
	}
}
