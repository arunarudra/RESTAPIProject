package RESTAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTReqWithFile {
	public RequestSpecification request;
	public Response response;
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI="http://localhost:3000/employees/";
		request=RestAssured.given();
		//response = request.get();
	}
	
	@Test
	public void test1() throws IOException {
		
		byte[] dataBytes= Files.readAllBytes(Paths.get("data.json"));
		response= request.contentType(ContentType.JSON).accept(ContentType.JSON).body(dataBytes).post("/create");
		
		String resBody= response.getBody().asString();
		System.out.println(resBody);
		
		JsonPath jpath = response.jsonPath();
		System.out.println(jpath.getString("id"));
			
	}
	
	@Test
	public void test2() {
		
		int resCode = response.getStatusCode();
		Assert.assertEquals(resCode, 201);
		System.out.println(resCode);
	}

}
