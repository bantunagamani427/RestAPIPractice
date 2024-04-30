
package Practice;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class AllEndToEnd {

	int id;//id should not be hardcoded so make it as global
	@Test(priority=1)
	public void getSingleUser() {
		given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all();		 
	}

	@Test(priority=2)
	public void GetAllUsers() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.log().all();
	}
	@Test(priority=3)
	public void createUser() {		
		HashMap hm=new HashMap();
		hm.put("name", "AmmA");
		hm.put("job", "Automation");

		id=given()
				.contentType("application/json")
				.body(hm)
				.when()
				.post("https://reqres.in/api/users")
				.jsonPath().getInt("id");	
	}
	@Test(priority=4,dependsOnMethods = {"createUser"})
	public void update() {
		HashMap hm=new HashMap();
		hm.put("name","BannuBittu");
		hm.put("job", "Automation");
		given()
		.contentType("application/json")
		.body(hm)
		.when()
		.put("https://reqres.in/api/users/"+id)//id should not hardcoded so it should taken from global
		.then()
		.statusCode(200)
		.log().all();		
	}
	@Test(priority=5,dependsOnMethods={"update"})
	public void delete() {
		given()
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)
		.log().all();
	}	
}
