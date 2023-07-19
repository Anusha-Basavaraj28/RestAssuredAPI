package Day3;

import org.testng.annotations.Test;
//static packages
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;
public class PathAndQueryParameters {
	
	
	//   https://reqres.in/api/users?page=2&id=5
	
	@Test
	void testPathAndQueryParameters() {
		
		given()
		.pathParam("myPath", "users")   //path parameters
		.queryParam("page", 2)  //query parameters
		.queryParam("id", 5)      //query parameters
		
		
		.when()
		.get("https://reqres.in/api/{myPath}")
		
		
		.then()
		.statusCode(200)
		.body("data.id",equalTo(5))
		.log().all();
		
		
	}

}
