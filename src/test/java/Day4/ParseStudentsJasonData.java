package Day4;
//static packages
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParseStudentsJasonData {
	@Test
	void testParseJsonData() {
		Response res=
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/students");
		
		JSONArray jArr=new JSONArray(res.asString());
		
		for (int i = 0; i < jArr.length(); i++) {
		String name=	jArr.getJSONObject(i).get("name").toString();
		String course1=jArr.getJSONObject(i).getJSONArray("courses").get(0).toString();
		String course2=jArr.getJSONObject(i).getJSONArray("courses").get(1).toString();
		
		System.out.println(name+"  "+course1+"   "+course2);
		
		}
	
	}

}
