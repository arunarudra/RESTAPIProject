package restBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequestBDD {
	
	@Test
	public void test1() {
		Map<String,Object> Mapobj= new HashMap<String,Object>();
		//JSONObject jobj= new JSONObject();
		Mapobj.put("name", "tom");
		Mapobj.put("salary", 3500);
		RestAssured.given()
		   .baseUri("http://localhost:3000/employees/")
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(Mapobj)
		   .post("/create")
		   .then()
		   .log()
		   .body()
		   .statusCode(201)
		   .body("name",Matchers.equalTo("tom"));
		
	}

}
