package RESTAPI;

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

public class PUTRequest {
	
	public RequestSpecification request;
	public Response response;
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI="http://localhost:3000/employees/";
		request=RestAssured.given();
		//response = request.get();
	}
	
	@Test
	public void test1() {
		
		RestAssured.baseURI="http://localhost:3000/employees/";
		Map<String,Object> Mapobj= new HashMap<String,Object>();
		Mapobj.put("name", "Krish");
		Mapobj.put("salary", 3000);
		response= request.contentType(ContentType.JSON).accept(ContentType.JSON).body(Mapobj).put("/1");
		
		String resBody= response.getBody().asString();
		System.out.println(resBody);
		
		JsonPath jpath = JsonPath.from(resBody);
		String value=jpath.getString("id");
		System.out.println(value);
			
	}
	
	@Test
	public void test2() {
		int resCode = response.getStatusCode();
		Assert.assertEquals(resCode, 200);
		System.out.println(resCode);
	}
		
		
	}
