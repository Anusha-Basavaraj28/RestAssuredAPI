package Day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

//static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadersDemo {

	@Test(priority = 1)
	void testHeaders() {
		given()

				.when().get("https://www.google.com/")

				.then()
				.header("Content-Type", "text/html; charset=ISO-8859-1")
				.header("Content-Encoding", "gzip")
				.header("Server", "gws")
				.log().all();

	}

	@Test(priority = 2)
	void getHeaders() {

		Response res = given()

				.when().get("https://www.google.com/");

		String headerValue = res.getHeader("Content-Type"); // get single header
		System.out.println("*******************************" + headerValue);

		Headers headers = res.getHeaders(); // get all headers

		for (Header h : headers) {
			System.out.println("&&&&&&&&&" + h.getName()+"   "+h.getValue());
		}

	}
}
