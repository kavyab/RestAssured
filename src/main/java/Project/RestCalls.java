package Project;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestCalls {
	public static Response GetRequest(String uRI)
	{	//trying to pass my request
		RequestSpecification requestspecification = RestAssured.given();
		//.header("Authorization", "bearer "+accesstoken)
		//either content type can be json/xml
		requestspecification.contentType(ContentType.JSON);
		//Trying to fetch the URL
		Response response = requestspecification.get(uRI);
		return response;
		
	}
	
	public static Response GetRequestwithHeader(String uRI , String accessToken)
	{	//trying to pass my request
		RequestSpecification requestspecification = RestAssured.given();		
		//either content type can be json/xml
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("Authorization", "Bearer "+accessToken);
		//Trying to fetch the URL
		Response response = requestspecification.get(uRI);
		return response;
		
	}
	
	public static Response PostRequest(String uRI , String strJson, String accessToken)
	{ //trying to pass my request
		RequestSpecification requestspecification = RestAssured.given().body(strJson);
		//either content type can be json/xml
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("Authorization", "Bearer "+accessToken);
		//Trying to fetch the URL
		Response response = requestspecification.post(uRI);
		return response;
		
	}
	public static Response PostRequestwithHeader(String uRI)
	{ //trying to pass my request
		RequestSpecification requestspecification = RestAssured.given();
		//either content type can be json/xml
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("Authorization", "Basic dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=");
		//Trying to fetch the URL
		Response response = requestspecification.post(uRI);
		return response;
		
	}
	public static Response PutRequest(String uRI , String strJson)
	{	//trying to pass my request
		RequestSpecification requestspecification = RestAssured.given().body(strJson);
		//either content type can be json/xml
		requestspecification.contentType(ContentType.JSON);
		//Trying to fetch the URL
		Response response = requestspecification.put(uRI);
		return response;
		
	}
	public static Response DeleteRequest(String uRI, String strJson)
	{//trying to pass my request
		RequestSpecification requestspecification = RestAssured.given().body(strJson);
		//either content type can be json/xml
		requestspecification.contentType(ContentType.JSON);
		//Trying to fetch the URL
		Response response = requestspecification.delete(uRI);
		return response;
		
	}
}
