package APIchaining;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AllMethods {
	
	public RequestSpecification request;
	public Response response;
	String baseuri = "http://localhost:3000/employees/";
	public Response GetAllEmp() {
		
		RestAssured.baseURI=baseuri;
		request=RestAssured.given();
		response = request.get();
		return response;
	}
	
	public Response CreateEmp(String empname, int empsalary) {
		RestAssured.baseURI=baseuri;
		JSONObject jobj= new JSONObject();
		jobj.put("name", empname);
		jobj.put("salary", empsalary);
		request=RestAssured.given();
		response= request.contentType(ContentType.JSON).accept(ContentType.JSON).body(jobj.toString()).post("/create");
		return response;
		
	}
	
	public Response PutMethod(int empID, String empname, int empsalary) {
		RestAssured.baseURI=baseuri;
		JSONObject jobj= new JSONObject();
		jobj.put("name", empname);
		jobj.put("salary", empsalary);
		request=RestAssured.given();
		response= request.contentType(ContentType.JSON).accept(ContentType.JSON).body(jobj.toString()).put("/"+ empID);
		return response;
		
	}
	
	public Response deleteMethod(int empID) {
		RestAssured.baseURI=baseuri;
		request=RestAssured.given();
		response = request.delete("/"+ empID);
		return response;
	}
	
	public Response getSingleEmpMethod(int empID) {
		RestAssured.baseURI=baseuri;
		request=RestAssured.given();
		response = request.get("/"+ empID);
		return response;
	}

}
