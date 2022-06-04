package RESTAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParams {
	
	public RequestSpecification request;
	public Response response;
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI="http://localhost:3000/employees/";
		request=RestAssured.given();
		//response = request.param("id", 3).get()
		response=request.get();
	}
	
	@Test
	public void test1() {
		String resBody = response.getBody().asString();
	    System.out.println(resBody);
		
		//Assert.assertTrue(resBody.contains("Aruna"));
		JsonPath jpath = response.jsonPath();
		List<String> names=jpath.get("name");
		for (String s:names) {
			System.out.println(s);
			Assert.assertEquals(s, "Aruna");
		}
		
	}
	
	@Test
	public void test2() {
		int resCode = response.getStatusCode();
		Assert.assertEquals(resCode, 200);
		System.out.println(resCode);
	}
	
	@Test
	public void test3() {
		String header = response.getHeader("Content-Type");
		System.out.println("header"+"  "+header);
		
	}

}
