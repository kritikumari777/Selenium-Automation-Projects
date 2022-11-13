package restassured;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class StaticImplemation {
	@Test
	public void givenThen() {
	     baseURI = "https://reqres.in/api";
	     
		given().
		 get("/users?page=2").
		then().
		 statusCode(200).
		 body("data[1].id", equalTo(8)).
		 log().all();
		
	}

}
