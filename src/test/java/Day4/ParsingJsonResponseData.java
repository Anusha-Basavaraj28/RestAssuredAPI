package Day4;


//static packages
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ParsingJsonResponseData {
//	@Test
	void testJsonResponse() {
		
		
		// Approach 1
	/*	
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get(" http://localhost:3000/store")
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		.body("book[4].title", equalTo("eee"));
		*/
		
		// Approach 2
		
		Response res=
				given()
				.contentType(ContentType.JSON)
				
				.when()
				.get("http://localhost:3000/store");
		
		// TestNG Assertions 
		
		/*Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
		
	   String title=	res.jsonPath().get("book[4].title").toString();
	
	   Assert.assertEquals(title, "eee"); */
	   
	  JSONObject  jo=new JSONObject(res.asString());
	  
	 for (int i = 0; i <jo.getJSONArray("book").length(); i++) {    // extract title of every book
		 
		String bookTitle= jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		System.out.println(bookTitle);
		
	}
	
	}
	
	@Test
	void testResponeTitles() {
		
		Response res=
				given()
				 .contentType("application/json")
				
				.when()
				.get("http://localhost:3000/store");
		
		  JSONObject  jo=new JSONObject(res.asString());
		  
		  boolean flag=false;
		  
			 for (int i = 0; i <jo.getJSONArray("book").length(); i++) {    // extract title of every book
				 
				String bookTitle= jo.getJSONArray("book").getJSONObject(i).get("title").toString();
				System.out.println(bookTitle);
				if(bookTitle.equals("eee")) {
					
					flag=true;
					break;
					
				}
	}

			 Assert.assertTrue(flag);
}
	@Test
	void testPrice() {
		Response res=
				given()
				 .contentType("application/json")
				
				.when()
				.get("http://localhost:3000/store");
		
		JSONObject jo=new JSONObject(res.asString());
		
		float sum=0;
		
		for (int i = 0; i <jo.getJSONArray("book").length(); i++) {
			
			String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			System.out.println(price);
			float pricef=Float.parseFloat(price);
			sum+=pricef;
			
		}
		System.out.println(sum);
		Assert.assertEquals(sum,1252.00 );
	}
	
	
}
