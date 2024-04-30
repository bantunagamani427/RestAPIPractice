package Practice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
public class AboutLogMethod {
	@Test
	public void logMethod() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		//.log().all();//print all
		//.log().headers();//to print only header
		.log().cookies();	
	 }
   }
