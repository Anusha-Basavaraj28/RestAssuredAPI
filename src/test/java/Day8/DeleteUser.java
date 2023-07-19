package Day8;
//static packages
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class DeleteUser {
	
	@Test
	void deleteUser(ITestContext context) {
		//int id=(Integer) context.getAttribute("userId");
		
		int id=(Integer) context.getSuite().getAttribute("userId");
		
		String bearerToken="80a4b43a94927e0c023324729cea8f7c2b43c2b574f95b5a5d478e4a50d1e0a9";
		
		given()
		.headers("Authorization", "Bearer "+bearerToken)
		.contentType(ContentType.JSON)
		.pathParam("myPath", id)
		
		.when()
		.delete("https://gorest.co.in/public/v2/users/{myPath}")
		
		.then()
		.statusCode(204).log().all();
	}

}
