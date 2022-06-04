package RESTAPI;

import java.util.List;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Testing {
	RequestSpecification request;
	JSONObject jobj= new JSONObject();
	@Test
	public void test1() {
		
		RestAssured.baseURI="http://localhost:3000/employees/";
		request= RestAssured.given();
		/*jobj.put("name", "prabhu");
		jobj.put("salary", "2000");*/
		
	//	Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(jobj.toString()).post("/create");
		
	//	Response response= RestAssured.request(Method.GET,"/all");
		Response response=request.get();
		String respBody= response.getBody().asString();
	/*	JsonPath jpath = JsonPath.from(respBody);
		List<Integer> empid=jpath.get("id");
		List<String> epname=jpath.get("name");
		for(int i=0;i<empid.size();i++) {
			if (empid.get(i)>=15&&empid.get(i)<=41) {
				System.out.println(empid.get(i)+"  "+epname.get(i));
			}
		} */
		System.out.println(respBody);
		 
		
	}

}
