package Auth;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAPIWithOAuth {
	
	public void getWithOAuth()
	{
		
		//For OAuth 1.0 we need to download scribe jars
		//For OAuth 2.0 no need to import scribe jars
		
		String consumerkey = "arg0";
		String consumetkey_secret = "arg1";
		String token = "arg2";
		String token_secret = "arg3";
		
		
		RestAssured.baseURI = "";
		
		//Header, body, parameter
		given().
			auth().oauth(consumerkey, consumetkey_secret, token, token_secret).log().all().
			param("arg0", "arg1").
		
		//resource
		when().
		
			get("resouce/../").
		
		//assertion
		then().
			assertThat().
				statusCode(200).log().all().
		//response()
		extract();
	}

}
