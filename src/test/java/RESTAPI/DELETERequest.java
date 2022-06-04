package RESTAPI;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETERequest {
	
	public RequestSpecification request;
	public Response response;
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI="http://localhost:3000/employees/";
		request=RestAssured.given();
		response = request.delete("/26");
	}
	
	@Test
	public void test1() {
		String resBody = response.getBody().asString();
		System.out.println(resBody);
		
	}
	
	@Test
	public void test2() {
		int resCode = response.getStatusCode();
		Assert.assertEquals(resCode, 404);
		System.out.println(resCode);
		
	}

}
