package restBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteRequestBDD {
	
	@Test
	public void test1() {
		RestAssured.given()
		   .baseUri("http://localhost:3000/employees/")
		   .when()
		   .delete("/44")
		   .then()
		   .log()
		   .status();
		
	}

}
