package Day7;

import org.testng.annotations.Test;
//static packages
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;
public class Authentications {
	@Test
	void testBasicAuthentication() {
		given()
		//.auth().basic("postman", "password")
		//.auth().digest("postman", "password")
		.auth().preemptive().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true)).log().all();
	}
	
	@Test
	void testBearerTokenAuthentication() {
		
		
		String bearerToken= "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";
		
		given()
		.header("Authorization","Bearer "+ bearerToken)
		
		.when()
		.get("https://api.github.com/users/repos")
		
		.then()
		.statusCode(200)
		.body("login", equalTo("repos")).log().all();
	}
	
	@Test
	void testOauth1Authentication() {
		
		
		given()
		.auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret")  // oauth1.0 Authentication syntax
		
		.when()
		.get("url")
		
		.then()
		.statusCode(200);
		
	
	}
	
	
	@Test
	void testOauth2Authentication() {
		
		
		given()
		.auth().oauth2("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")
		
		.when()
		.get("https://api.github.com/users/repos")
		
		.then()
		.statusCode(200).log().all();
		
	
	}
	
	
	@Test
	void testApiKeyAuthentication() {
		
		
		given()
		.pathParam("mypath1", "geo/1.0/direct")
		//.pathParam("mypath2", "1.0")
		//.pathParam("mypath3", "direct")
		.queryParam("q", "London")
		.queryParam("limit", "5")
		.queryParam("appid", "d1c2aa72421681d4fa8b5a14a3aac1c7")  // appid is API Key.  we should pass it as query parameters
		
		.when()
		.get("http://api.openweathermap.org/{mypath1}")
		
		.then()
		.statusCode(200).log().all();
		
	
	}
	
	
	
}
