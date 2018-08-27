package demo;

import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payload.PostPayload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

public class PostAPITest extends TestBase {
	
	public PostAPITest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void postCall()
	{
		RestAssured.baseURI = prop.getProperty("HOST");
		
		
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
			body("status", equalTo("ok"));
			
		
	}

}
