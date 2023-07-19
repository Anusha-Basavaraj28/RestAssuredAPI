package Day1;

import org.testng.annotations.Test;

// static packages
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.util.HashMap;



//    Get request
//      https://reqres.in/api/users/2


// Post request
//      https://reqres.in/api/users

/* body
 * {
    "name": "morpheus",
    "job": "leader"
  }
 * 
 * 
 * 
 * Put requset
 * 
 *      https://reqres.in/api/users/2
 * 
 * {
    "name": "morpheus",
    "job": "zion resident"
}



Delete Request

        https://reqres.in/api/users/2
 * 
 */




public class HttpRequests {
	
	
	int id;           //Global variable

  @Test(priority = 1)
	void getUsers() {
		given()
		
		.when()
		     .get(" https://reqres.in/api/users?page=2")
		 
		.then()
		    .statusCode(200)
		    .body("page",equalTo(2))
		    .log().all();
	}
	
	
	@Test(priority = 2)
	void createUser() {
		
		HashMap<String, String> data=new HashMap<String, String>();
		
		data.put("name", "morpheus");
		data.put("job", "zion resident");
		
		id=given()
		   .contentType("application/json")
		   .body(data)
		
		.when()
		  .post("https://reqres.in/api/users")
		  .jsonPath().getInt("id");      // capture id from json response
		  
		 
		
		//.then()
		//  .statusCode(201)
		//  .body("name", equalTo("morpheus"))
		//  .log().all(); 
		
		
		
	}
	
	@Test(priority = 3,dependsOnMethods = {"createUser"})
	void updateUser() {
		
		
      HashMap<String, String> data=new HashMap<String, String>();
		
		data.put("name", "morpheus");
		data.put("job", "zion resident");
		
		   given()
		   .contentType("application/json")
		   .body(data)
		
		.when()
		  .put("https://reqres.in/api/users/"+id)   // from the global variable concatenate id with request url
		  
		  .then()
		  .statusCode(200)
		 .body("job", equalTo("zion resident"))
		 .log().all();
	}
	
	
	@Test(priority = 4)
	void deleteUser() {
		
		given()
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log().all();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
