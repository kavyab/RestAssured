package Test;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Project.Assertion;
import Project.BaseTest;
import Project.RestCalls;
import Utility.TestUtil;
import Utility.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestAPI {

	
		Response response;
		public String accessToken;
		@BeforeTest
		public void setup() throws IOException 
		{
			accessToken = BaseTest.getAccessToken();
			BaseTest.login();
			
		}
		
		
		
		@Test
		public void getAdminUserDetails()
		{
			String endpointURI = URL.getEndpoint("/api/rest_admin/user");
			response = new RestCalls().GetRequestwithHeader(endpointURI, accessToken);
			String strresponse = TestUtil.getResponseString(response);
			System.out.println(strresponse);
			JsonPath jsonres = TestUtil.jsonparser(strresponse);
			String userdetail = jsonres.getString("data");
			System.out.println(userdetail);
			Assertion.verifyStatusCode(response, 200);
		}
			
		
				
		
		@Test
		public void addNewCustomer() throws IOException
		{
			int success = BaseTest.addNewCust();
			Assertion.verifySuccessCode(response, success);
		}
		
		
		@AfterTest
		public void logout()
		{
			String endpointURI = URL.getEndpoint("/api/rest_admin/logout");
			response = new RestCalls().GetRequestwithHeader(endpointURI, accessToken);
			String strresponse = TestUtil.getResponseString(response);
			System.out.println(strresponse);
			JsonPath jsonres = TestUtil.jsonparser(strresponse);
			int success = jsonres.getInt("success");
			Assertion.verifySuccessCode(response, success);
			System.out.println("Logged out successfully");
			
			
		}
		
}
