package demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetMultipleAPITest extends TestBase {
	public GetMultipleAPITest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public static void getCall()  {
		// TODO Auto-generated method stub

		RestAssured.baseURI = prop.getProperty("HOST");
		
		Response res = 
		given().
			param("location", "-33.8670522,151.1957362").
			param("radius", "500").
			//pathParam(arg0, arg1).
			param("key", prop.getProperty("key")).log().all().
			// header("username","test").
			// header("password","test123").
			// cookie("test","test").
			// body("id","3")
		when().
			get(prop.getProperty("getResource")).
		then().
			assertThat().
			statusCode(200).
			and().
			contentType(ContentType.JSON).
			and().
			//body("results[0].geometry.location.lat",equalTo("-33.8585858")).
			//and().
			//body("results[0].place_id",equalTo("ChIJi6C1MxquEmsR9-c-3O48ykI")).  //equalTo is applicable only for body
			//and().
			header("server","scaffolding on HTTPServer2").log().all().
		extract().
			response();
		
		String responseString = res.asString();
		//System.out.println(responseString);
		JsonPath jsonPath = new JsonPath(responseString);
		
		int resultCount = jsonPath.get("results.size()");
		System.out.println(resultCount);
		
		for (int i = 0; i<resultCount; i++)
		{
			jsonPath.get("results["+i+"].name");
		}
		
	}

}
