package demo;

import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payload.DeletePayLoad;
import payload.PostPayload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

public class AddAndDeleteAPITest extends TestBase {
	
	public AddAndDeleteAPITest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Test
	public void addAndDeleteCall()
	{
		RestAssured.baseURI = prop.getProperty("HOST");
		
		Response res = 		
		given().
			queryParam("key", prop.getProperty("key")).
			// header("username","test").
			// header("password","test123").
			// cookie("test","test").
			body(PostPayload.postPayLoad()).
		when().
			post(prop.getProperty("postResource")).
		then().
			assertThat().
			contentType(ContentType.JSON).
			body("status", equalTo("ok")).
		extract().
			response();
		
		//putting the response in String
		String responseString = res.asString(); 
		
		//grab the place id from the response
		JsonPath jsonpath = new JsonPath(responseString);
		String placeId = jsonpath.get("place_id");
		
		//place the place id in delete request
		given().
			queryParam("key", prop.getProperty("key")).
			body(DeletePayLoad.deletePayLoad(placeId));
		when().
			delete(prop.getProperty("deleteresource")).
		then().
			assertThat().
			statusCode(200).
			contentType(ContentType.JSON).
			body("status", equalTo("ok"));
	}
	
}
