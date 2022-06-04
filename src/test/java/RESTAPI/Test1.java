package RESTAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test1 {
	@Test
	public void getMethod() {
		RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("http://localhost:3000/employees/");
		
		Response resp= reqspec.get();
		String respBody=resp.getBody().asString();
		System.out.println(respBody);
		System.out.println(resp.getStatusCode());
		
		JsonPath jpath = resp.jsonPath();
		List<String> empname=jpath.get("name");
		for(int i=0;i<empname.size();i++) {
		System.out.println(empname.get(i));
		Assert.assertEquals(empname.get(i), "shekhar");
		}
		
	}
	
	public void putMethod() throws IOException {
		RestAssured.baseURI=" http://api.github.com";
		byte[] dataBytes = Files.readAllBytes(Paths.get("data1.json"));
		RequestSpecification req=RestAssured.given();
		Response resp=req.auth().oauth2(" ").contentType(ContentType.JSON).accept(ContentType.JSON).body(dataBytes).post();
	}

}
