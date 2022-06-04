package restBDD;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestBDD {
	
	@Test
	public void test() {
		RestAssured.given()
				   .baseUri("http://localhost:3000/employees/")
				   .when()
				   .get()
				   .then()
				   .log()
				   .body()
				  // .status()
				   .statusCode(200);
				  // .all();
		
		
	}
	
	@Test
	public void test1() {
		RestAssured.given()
				   .baseUri("http://localhost:3000/employees/")
				   .when()
				   .get("/3")
				   .then()
				   .log()
				   .body()
				  // .status()
				   .statusCode(200);
				  // .all();
		
		
	}
	
	@Test
	public void test2() {
		RestAssured.given()
				   .baseUri("http://localhost:3000/employees/")
				   .queryParam("name", "Aruna")
				   .when()
				   .get()
				 //  .queryParam("name", "pankaj")
				   .then()
				   .log()
				   .body()
				  // .status()
				   .statusCode(200)
				 .body("[0].name",Matchers.equalTo("Aruna"));
				 // .all();
		
	}
	
	@Test
	public void test3() {
		Response response= RestAssured.given()
									   .baseUri("http://localhost:3000/employees/")
									   .queryParam("name", "pankaj")
									   .when()
									   .get();
		
		JsonPath jpath = response.jsonPath();
		List<String> names=jpath.get("name");
		String header=response.getHeader("Content-Type");
		for (String s:names) {
			System.out.println(s);
			Assert.assertEquals(s, "Aruna");
		}							 
		
		System.out.println(header);
	}

}
