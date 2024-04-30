package ways4OfCreatingPOST;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class CreatePOSTRequestUsingPOJO {
	@Test(priority=1)
	public void usingPOjo() {
		POJOClass data=new POJOClass();
		data.setname("AmmaNanna");
		data.setlocation("Annavaram");
		data.setphone_number("63432497");
		 String[] coursesArr= {"C","C++"};
		 data.setcourses(coursesArr);
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.body("name", equalTo("AmmaNanna"))
		.body("location", equalTo("Annavaram"))
		.body("phone_number", equalTo("63432497"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.log().all(); 
	}
	@Test(priority=2)
	public void deleteUser() {
		given()
		.when()
		.delete("https://reqres.in/api/users/900");
	}
  }



