package Day6;
//static packages
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

//  https://jsonformatter.org/json-to-jsonschema   -----> Json schema generator

public class JsonSchemaValidations {
	@Test
	void jsonSchemaValidation() {
		
		given()
		
		.when()
		.get("http://localhost:3000/store")
		
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));
		
	}

}
