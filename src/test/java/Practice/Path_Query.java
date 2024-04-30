package Practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Path_Query {
	@Test
	public void PathandQuery() {
		given()
		.pathParam("mypath", "users")//for path parameter variable name can be anything
		.queryParam("page", 2)
		.queryParam("id", 5)//but for query we have to maintain same variable
		.when()
		.get("https://reqres.in/api/{mypath}")//here no need to pass query parameter 
		//because query parameters send along with the request
		.then()
		.statusCode(200).log().all();
	   }
	//https://reqres.in/api/users?page=2
}
