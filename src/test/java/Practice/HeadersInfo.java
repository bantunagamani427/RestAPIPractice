package Practice;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadersInfo {
	@Test
	public void validateHeaders() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.header("Content-Type","text/html; charset=ISO-8859-1");
		//.log().all();
		//	.header("", "")
		//	.header("", "");
	}
	//String header_value=res.header("Content-Type");
	//System.out.println("header value-->"+header_value);
	@Test
	public void getHeaders() {
		Response res=given()
				.when()
				.get("https://www.google.com/");
		//get the single header
		String header_value=res.getHeader("Content-Type");
		System.out.println("Header value-->"+header_value);
		Headers headers = res.getHeaders();
		//return type is not a hashmap but header also can store the value 
		for(Header header:headers) {
			System.out.println("header name ==>"+header.getName()+"header value ==>"+header.getValue());	
		}
	}
}