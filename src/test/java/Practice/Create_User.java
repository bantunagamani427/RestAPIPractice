package Practice;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Create_User {
	@Test
	public void createUser() {
		HashMap hm=new HashMap();
		hm.put("name", "Nagamani");
		hm.put("job", "Tester");
		given()
		.contentType("application/json")
		.body(hm)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log()
		.all();
	}
}
