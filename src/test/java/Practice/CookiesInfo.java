package Practice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesInfo {
	@Test(priority=1)
	public void gerSingleCookie() {
		given()
		.get("https://www.google.com/")
		.then()
		.cookie("AEC", "AQTF6HzhaqhlXUhVX2Em-XaFL8s9TgfCVqBdrT0PzWC20adWlqxFjl_IRpU")
		//cookie value is not same everytime so assertion may get failed
		.log().all();
	}
	@Test(priority=2)
	public void getMultipleCookievalues() {
		Response res=given()
				.when()
				.get("https://www.google.com/");

		//getting the single cookie value
		String Cookie_value=res.getCookie("AEC");
		System.out.println("cookie_value-->"+Cookie_value);

		//getting multiple cookie values
		Map<String, String> cookies = res.getCookies();
		System.out.println("multiple keys-->"+cookies);
		for(String eachKey :cookies.keySet()) {//iterate for the each key
			String each_value=res.getCookie(eachKey);//if we pass each key then value we will get
			System.out.println(eachKey+"-->"+each_value);
		}
	  }
	}