package Day6;
//static packages
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;


public class XMLSchemaValidations {

	// http://restapi.adequateshop.com/api/Traveler
	
	// https://www.convertsimple.com/convert-xml-to-xsd-xml-schema/  --> XML scema converter
	@Test
	void xmlSchemaValidation() {
		
		given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler")
		
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveller.xsd"));
		
	}
}
