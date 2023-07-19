package Day3;

import org.testng.annotations.Test;
//static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class LoggingDemo {
	@Test
	void testLogs() {
	given()
		
		.when()
		     .get(" https://reqres.in/api/users?page=2")
		 
		.then()
		    .statusCode(200)
		 //  .log().all();
		  //  .log().body();
		  //  .log().cookies();
		   // .log().headers();
		   // .log().status();
		    .log().everything();
	
	}

}
