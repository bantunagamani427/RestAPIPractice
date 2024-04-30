package AllRequests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class GetSingleUser {
@Test
public void getSingleuser() {
	given()
	.when()
	.get("https://reqres.in/api/users/2")
	.then()
	.statusCode(200)
	.log().all();
}
}
