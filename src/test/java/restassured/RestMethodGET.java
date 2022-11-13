package restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestMethodGET {
   
	@Test
	
	public void testGetMethod() {
		
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httpResponce = RestAssured.given();  //
		
		Response response = httpResponce.request(Method.GET, " "); // Send the Request to the server.
		
		System.out.println("Status reseved => "+ response.getStatusLine()); //Get the Response back from the server.
		System.out.println("Responce => "+ response.prettyPrint());  //Print the returned Response�s body.
	}
	
	//or
	@Test
	
	public void testGetRequest() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println("code=> "+response.getStatusCode());
		System.out.println("line=> "+response.getStatusLine());
		System.out.println("time=> "+response.getTime());
		System.out.println("header=> "+response.getHeader("content-type"));
		System.out.println("body=> "+response.getBody().asString());
	
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}

}


