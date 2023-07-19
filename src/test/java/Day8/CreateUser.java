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



public class CreateUser {
	@Test
	void createUser(ITestContext context) {
		
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("email", faker.internet().emailAddress());
		data.put("gender", "male");
		data.put("status", "active");
		
		String bearerToken="80a4b43a94927e0c023324729cea8f7c2b43c2b574f95b5a5d478e4a50d1e0a9";
		
		int id=
		given()
		.headers("Authorization", "Bearer "+bearerToken)
		.contentType(ContentType.JSON)
		.body(data.toString())
		
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		
		//.then()
	//	.statusCode(201).log().all();
		
		
   System.out.println(id);
   
   //context.setAttribute("userId", id); ----> set the attribute to the test level.
   context.getSuite().setAttribute("userId", id);   //----> set the attribute to the suit level. all the tests within that test can access the attribute.
		
	}

}
