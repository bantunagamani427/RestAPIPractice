package Practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class GetSingleUser {
	@Test
	public void getSingleUser() {
		given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all();	
	}
}
