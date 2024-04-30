package ways4OfCreatingPOST;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;
public class CreatingPOSTusingHashmap {

	@Test(priority=1)
	public void  createUser() {
		HashMap hm=new HashMap();
		hm.put("name", "Uma");
		hm.put("subject", "Maths");
		hm.put("course", "java");
		given()
		.contentType("application/json")
		.body(hm)
		.when()
        .post("https://reqres.in/api/users")
        .then()
        .body("name", equalTo("Uma"))
        .body("subject", equalTo("Maths"))
        .body("course", equalTo("java"))
        .statusCode(201)
        .log().all();	
	}	
	@Test(priority=2)
	public void deleteUser() {
		given()
		.when()
		.delete("https://reqres.in/api/users/900")
		.then()
		.log().all();
	}
}
