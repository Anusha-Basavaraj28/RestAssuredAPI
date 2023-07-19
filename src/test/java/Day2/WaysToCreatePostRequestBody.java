package Day2;

import org.testng.annotations.Test;
import org.json.JSONObject;
import org.json.JSONTokener;

//static packages
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;


public class WaysToCreatePostRequestBody {
	
	//int id;
	
	// by suing HashMap create jason data.
	
	//@Test(priority = 1)
	void testPostUsingHashMap() {
		
		HashMap<String,Object> data =new HashMap<String,Object>();
		String coursesArr[]= {"C","C++"};
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "1234567898");
		data.put("courses", coursesArr);
		
		given()
		  .contentType("application/json")
		  .body(data)
		  
		  .when()
		   .post("http://localhost:3000/students")
		//   .jsonPath().getInt("id")
		   
		   .then()
		   .statusCode(201)
		   .body("name", equalTo("Scott"))
		   .body("location", equalTo("France"))
		   .body("phone", equalTo("1234567898"))
		   .body("courses[0]",equalTo( "C"))
		   .body("courses[1]",equalTo( "C++"))
		   .header("content-Type", "application/json; charset=utf-8")
		   .log().all();
		 
	}
	
	@Test(priority = 2)
	void deleteStudent() {
		
		when()
		.delete("http://localhost:3000/students/4")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	// Post request body using org.json library
	//@Test(priority = 1)
	void testPostUsingOrgJsonLibrary() {
		
		JSONObject data=new JSONObject();   // from org.json library dependency
		String coursesArr[]= {"C","C++"};
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "1234567898");
		data.put("courses", coursesArr);
		
		given()
		  .contentType("application/json")
		  .body(data.toString())
		  
		  .when()
		   .post("http://localhost:3000/students")
		//   .jsonPath().getInt("id")
		   
		   .then()
		   .statusCode(201)
		   .body("name", equalTo("Scott"))
		   .body("location", equalTo("France"))
		   .body("phone", equalTo("1234567898"))
		   .body("courses[0]",equalTo( "C"))
		   .body("courses[1]",equalTo( "C++"))
		   .header("content-Type", "application/json; charset=utf-8")
		   .log().all();
		 
	}
	
	// post request body using pojo class
	
	//@Test(priority = 1)
	void testPostUsingPOJOClass() {
		
		POJORequst data=new POJORequst();
		String courses[]= {"C","C++"};
		data.setName("Scott");
		data.setLocation("France");
		data.setPhone("1234567898");
		data.setCourses(courses);
		
		given()
		  .contentType("application/json")
		  .body(data)
		  
		  .when()
		   .post("http://localhost:3000/students")
		//   .jsonPath().getInt("id")
		   
		   .then()
		   .statusCode(201)
		   .body("name", equalTo("Scott"))
		   .body("location", equalTo("France"))
		   .body("phone", equalTo("1234567898"))
		   .body("courses[0]",equalTo( "C"))
		   .body("courses[1]",equalTo( "C++"))
		   .header("content-Type", "application/json; charset=utf-8")
		   .log().all();
		 
	}
	
	@Test(priority = 1)
	void testPostUsingJsonFile()  {
		
		File f=new File(System.getProperty("user.dir")+"/body.json");
		
		FileReader fr;
		try {
			fr = new FileReader(f);
			JSONTokener jt=new JSONTokener(fr);
			
			JSONObject data=new JSONObject(jt);
			
			given()
			  .contentType("application/json")
			  .body(data.toString())
			  
			  .when()
			   .post("http://localhost:3000/students")
			//   .jsonPath().getInt("id")
			   
			   .then()
			   .statusCode(201)
			   .body("name", equalTo("Scott"))
			   .body("location", equalTo("France"))
			   .body("phone", equalTo("1234567898"))
			   .body("courses[0]",equalTo( "C"))
			   .body("courses[1]",equalTo( "C++"))
			   .header("content-Type", "application/json; charset=utf-8")
			   .log().all();
			 
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	
	
	}
	

}
