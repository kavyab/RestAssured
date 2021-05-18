package Project;

import java.io.IOException;

import org.testng.annotations.Test;

import Utility.Payloadconvertor;
import Utility.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {
	static Response response;
	public static String accessToken;
//	
	
	
	public static String getAccessToken() throws IOException  {
		{
			//This line will go to the resource, fetchthe payload & convert it into String
			//String signuppayload = Payloadconvertor.generatePayloadstring("");
			//This line will fetch the URL along with the resource
			String endpointURL = URL.getEndpoint("/api/rest_admin/oauth2/token/client_credentials");
			//This line is to call the post method from the restcall
			response = RestCalls.PostRequestwithHeader(endpointURL);
			String strres = response.getBody().asString();
			System.out.println("AccessToken response :"+strres);
			JsonPath jsonres = new JsonPath(strres);
			accessToken = jsonres.getString("data.access_token");
			System.out.println(accessToken);
			return accessToken;
		}
	}
	
	public static String login() throws IOException  {
		{
			//This line will go to the resource, fetchthe payload & convert it into String
			String signuppayload = Payloadconvertor.generatePayloadstring("login.json");
			//This line will fetch the URL along with the resource
			String endpointURL = URL.getEndpoint("/api/rest_admin/login");
			//This line is to call the post method from the restcall
			response = RestCalls.PostRequest(endpointURL, signuppayload,accessToken);
			String strres = response.getBody().asString();
			System.out.println("Login Response :"+strres);
			JsonPath jsonres = new JsonPath(strres);
			String successcode = jsonres.getString("success");
			System.out.println(successcode);
			return successcode;
		}}
		
	public static int addNewCust() throws IOException  {
			{
				//This line will go to the resource, fetchthe payload & convert it into String
				String signuppayload = Payloadconvertor.generatePayloadstring("addnewcustomer.json");
				//This line will fetch the URL along with the resource
				String endpointURL = URL.getEndpoint("/api/rest_admin/customers");
				//This line is to call the post method from the restcall
				response = RestCalls.PostRequest(endpointURL, signuppayload,accessToken);
				String strres = response.getBody().asString();
				System.out.println("AddCustomerResponse :"+strres);
				JsonPath jsonres = new JsonPath(strres);
				int successcode = jsonres.getInt("success");
				System.out.println(successcode);
				return successcode;
			}
	}
	
	
}