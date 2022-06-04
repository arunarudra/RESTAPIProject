package restAPIXML;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;

public class XMLTest {
	
	@Test
	public void test1() {
		
		RestAssured.given()
		   .baseUri("https://chercher.tech/sample/api/books.xml")
		   .when()
		   .get()
		   .then()
		   .log()
		   .body()
		   .statusCode(200);
		  
		
	}

	@Test
	public void test2() {
		
	Response response=	RestAssured.given()
		   .baseUri("https://chercher.tech/sample/api/books.xml")
		   .when()
		   .get();
	NodeChildrenImpl books=response.then().extract().path("bookstore.book.title");
	//System.out.println("  "+books);
	
	System.out.println("Available books are ");
	for (String b:books) {
		System.out.println(b.toString());
	}
	
	
	NodeChildrenImpl authors=response.then().extract().path("bookstore.book.author");
	
	System.out.println(authors);
	System.out.println("Language of first book is  "+ books.get(0).getAttribute("lang"));
		   

	NodeChildrenImpl prices=response.then().extract().path("bookstore.book.price");
	System.out.println("price of paperback is  "+prices.get(0).children().get("paperback"));
	System.out.println(prices.size());
	for(int i=0; i<prices.size();i++) {
	System.out.println(prices.get(i).toString());
	}
	}
}
