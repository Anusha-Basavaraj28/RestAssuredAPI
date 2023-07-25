package Day9;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SOAO_API_testing {
	
	@Test
	public void soapAPIValidation() throws IOException {
		
		baseURI="http://www.dneonline.com";
		
		File f=new File("C:\\Users\\anush\\RestAssuredAPITesting\\RestAssuredAPI\\SOAPRequest\\add.xml");
		if(f.exists()) {
			System.out.println(">> File exists");
		}
		FileInputStream fi=new FileInputStream(f);
		
		String resquestBody=IOUtils.toString(fi, "UTF-8");
		
		given()
		.contentType("text/xml")
		.header("Accept", "text/xml")
		.body(resquestBody)
		
		.when()
		.post("/calculator.asmx")
		
		.then()
		.statusCode(200)
		.body("//*:AddResult.text()", equalTo("9"))
		.log().all();
		
	}

}
