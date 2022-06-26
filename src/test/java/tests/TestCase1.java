package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TestCase1 {
	//@Test
	public void test1() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	//@Test
	public void test2() {
		baseURI = "https://reqres.in";
		given().get("/api/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();
	}
	
	@Test
	public void postRequest() {
		baseURI="https://reqres.in/api";
		JSONObject request=new JSONObject();
		request.put("name", "TestUser");
		request.put("Role", "TeamLead");
		
		given().
		 header("Content-Type","application/jason").
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(request.toJSONString()).
		when().
		 post("/users").
		 then().
		 statusCode(201).
		 log().all();
		
		
	}

}
