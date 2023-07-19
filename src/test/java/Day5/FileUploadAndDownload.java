package Day5;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

//static packages
import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.io.File;



public class FileUploadAndDownload {
	@Test
	void singleFileUpload() {
		
		
		File f=new File("C:\\Users\\anush\\OneDrive\\Desktop\\GitHub.txt");
		
		given()
		.multiPart("file",f)
		.contentType(ContentType.MULTIPART)
		
		
		
		.when()
		.post("http://localhost:8080/uploadFile")
		
		.then()
		.statusCode(200)
		.body("fileName",equalTo("GitHub.txt")).log().all();
		//.body("fileType",equalTo("text/plain"));
	}
	
	
	@Test
	void multipleFileUpload() {
		
		
		File f1=new File("C:\\Users\\anush\\OneDrive\\Desktop\\GitHub.txt");
		File f2=new File("C:\\Users\\anush\\OneDrive\\Desktop\\Hello.java");
		
		File fileArr[] = {f1,f2};
		
		given()
		.multiPart("files",f1)
		.multiPart("files",f2)
		//.multiPart("files",fileArr)
		.contentType(ContentType.MULTIPART)
		
		
		
		.when()
		.post("http://localhost:8080/uploadMultipleFiles")
		
		.then()
		.statusCode(200)
		.body("[0].fileName",equalTo("GitHub.txt"))
		.body("[1].fileName",equalTo("Hello.java"))
		.log().all();
		
	}
	
	@Test
	void fileDownload() {
		given()
		
		.when()
		.get("http://localhost:8080/downloadFile/GitHub.txt")
		.then().statusCode(200)
		.log().all();
	}

}
