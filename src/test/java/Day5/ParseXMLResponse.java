package Day5;
//static packages
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;



public class ParseXMLResponse {
	@Test
	void testXmlResponseBody() {
		
		// Approach 1
		
		given()
		.contentType(ContentType.XML)
		.pathParam("myPath", "Traveler")
		.queryParam("page", 1)
		
		.when()
		.get("http://restapi.adequateshop.com/api/{myPath}")
		
		.then()
		.statusCode(200)
		.header("content-type", "application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page", equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"))
		.log().all();
		
	}
	
	
	
	@Test
	void testXmlResponseBody2() {
		
		// Approach 2  Response object
		Response res=
		given()
		.contentType(ContentType.XML)
		.pathParam("myPath", "Traveler")
		.queryParam("page", 1)
		
		.when()
		.get("http://restapi.adequateshop.com/api/{myPath}");
		
		
		//Assert.assertEquals(res.getHeader("content-type"), "application/xml; charset=utf-8");
		//Assert.assertEquals(res.getStatusCode(), 200);
		
	  // String pageNum=	res.xmlPath().get("TravelerinformationResponse.page").toString();
	   // Assert.assertEquals(pageNum, "1");
		
		
		// no of travellers
		XmlPath xmlObj=new XmlPath(res.asString());
		
		List<String> travellersList=  xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		
		int travellerSize=travellersList.size();
		
		Assert.assertEquals(travellerSize, 10);
		
		// traveller names
		List<String> travellersNmaes=  xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		boolean flag=false;
		for (String o : travellersNmaes) {
			System.out.println(o);
			if(o.equals("vano")) {
				flag=true;
				break;
			}
		}
		
		
			Assert.assertTrue(flag);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
