package ways4OfCreatingPOST;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class CreatePOSTUsingJSONObject {
	@Test
	public void createUser() {
		JSONObject obj=new JSONObject();
		obj.put("name", "Akshith");
		obj.put("subject", "Science");
		obj.put("Location","Gopavaram");
		obj.put("phoneNumber", "78435737");
		given()
		.contentType("application/json")
		.body(obj.toString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.body("name", equalTo("Akshith"))
		.body("subject",equalTo("Science"))
		.body("Location",equalTo("Gopavaram")).log().all();
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




