package ways4OfCreatingPOST;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
public class UsingExternalFile {
	@Test
	public void externalFile() throws FileNotFoundException {
		File f=new File(".\\body.json");
		//File is used to set the path of the file
		FileReader fr=new FileReader(f);
		//fileReader class is used to read the data
		JSONTokener jr=new JSONTokener(fr);
		//JsonTokener is used to extract the data	
		
		JSONObject data=new JSONObject(jr);
		//extracted data is convert from json data with the help of JSONObject			
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.log().all();
		




		/*
		 * File f=new File("path of the file);
		 * FileReader fr=new FileReader(f)
		 * JsonTokener jt=new JsonTokener(fr)
		 * JsonObject data=new JsonObject();
		 * 
		 * 
		 */


	}
}
