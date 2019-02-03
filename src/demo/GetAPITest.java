package demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetAPITest extends TestBase {
	public GetAPITest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public static void getCall()  {
		// TODO Auto-generated method stub

		RestAssured.baseURI = prop.getProperty("HOST");

		given().
			param("location", "-33.8670522,151.1957362").
			param("radius", "500").
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
			body("results[0].geometry.location.lat",equalTo("-33.8585858")).
			and().
			body("results[0].place_id",equalTo("ChIJi6C1MxquEmsR9-c-3O48ykI")).  //equalTo is applicable only for body
			and().
			header("server","scaffolding on HTTPServer2");
	}

}
