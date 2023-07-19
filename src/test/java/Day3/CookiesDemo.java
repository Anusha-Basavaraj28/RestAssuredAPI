package Day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

//static packages
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class CookiesDemo {
	@Test(priority = 1)
	void testCookies() {
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.cookie("AEC")
		.log().all();
		
	}
	
	
	@Test(priority = 2)
	void getCookiesInfo() {
		
	Response	res=given()       // captured response
		
		.when()
		.get("https://www.google.com/");
		
	// get cookie info
		String cookie_value=res.getCookie("AEC");
		
		System.out.println("value os single cookie AEC  "+cookie_value);
		
		Map<String, String> cookies=res.getCookies();  // get all cookies
		
		System.out.println("Value of all the cookies");
		
		for (Map.Entry<String, String> entry : cookies.entrySet()) {
			
			System.out.println(entry.getKey()+"  "+entry.getValue());
			
		}
		
		
		
	}

}
