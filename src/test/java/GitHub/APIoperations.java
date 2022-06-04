package GitHub;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIoperations {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI="https://api.github.com/users/arunarudra/repos";
		RequestSpecification request=RestAssured.given();
		Response response = request.get();
		String resBody = response.getBody().asString();
		System.out.println(resBody);
		int respcode = response.getStatusCode();
		System.out.println(respcode);
		
	} 
	
	@Test
	public void test2() throws IOException {
		RestAssured.baseURI="https://api.github.com/user/repos";
		byte[] dataBytes= Files.readAllBytes(Paths.get("data1.json"));
		RequestSpecification request=RestAssured.given();
		Response response= request.auth().oauth2("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")
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.body(dataBytes)
						.post();
		int respcode= response.getStatusCode();
		Assert.assertEquals(respcode, 201);
		System.out.println(respcode);
		
		
	}

}
