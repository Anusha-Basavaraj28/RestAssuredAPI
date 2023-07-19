package Day8;
//static packages
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;


public class UpdateUser {
	@Test
	void updateUser(ITestContext context) {
       Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("email", faker.internet().emailAddress());
		data.put("gender", "female");
		data.put("status", "inactive");
		
		//  int id=(Integer) context.getAttribute("userId");
		int id=(Integer) context.getSuite().getAttribute("userId");
		
		String bearerToken="80a4b43a94927e0c023324729cea8f7c2b43c2b574f95b5a5d478e4a50d1e0a9";
		
		given()
		.headers("Authorization", "Bearer "+bearerToken)
		.contentType(ContentType.JSON)
		.body(data.toString())
		.pathParam("myPath", id)
		
		.when()
		.put("https://gorest.co.in/public/v2/users/{myPath}")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
