package APIchaining;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class EndToEndTest {
	AllMethods alm= new AllMethods();
	String resBody;
	
	@Test
	public void test1() {
		Response response;
		
		response=alm.GetAllEmp();
		int resCode = response.getStatusCode();
		Assert.assertEquals(resCode, 200);
		System.out.println(resCode);
		
		response = alm.CreateEmp("rocky", 2500);
		Assert.assertEquals(response.getStatusCode(), 201);
		JsonPath jpath= response.jsonPath();
		int empid=jpath.get("id");
		System.out.println("EmpId :"+"  "+empid);
		resBody=response.getBody().asString();
	    System.out.println(resBody);
		//System.out.println(resCode);
	    
	    response = alm.PutMethod(empid, "Bravo", 5000);
	    Assert.assertEquals(response.getStatusCode(), 200);
	    jpath= response.jsonPath();
	    String empName=jpath.get("name");
	    Assert.assertEquals(empName, "Bravo");
	    
	    response= alm.deleteMethod(empid);
	    Assert.assertEquals(response.getStatusCode(), 200);
	    System.out.println(response.getStatusCode());
	    String resBody = response.getBody().asString();
	    Assert.assertEquals(resBody, "{}");
	    
	    response= alm.getSingleEmpMethod(empid);
	    Assert.assertEquals(response.getStatusCode(), 404);
	    System.out.println(response.getStatusCode());
	    
	    
	    
		System.out.println(resBody);
	   
		
		
		
	}

}
