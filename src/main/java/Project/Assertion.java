package Project;

import org.testng.Assert;

import Utility.TestUtil;
import io.restassured.response.Response;

public class Assertion {
	
	
	public static void verifyStatusCode(Response response, int status)
	{
		Assert.assertEquals(TestUtil.getStatusCode(response), status);
	}
	
	public static void verifySuccessCode(Response response, int success)
	{
		Assert.assertEquals(success, 0);
	}


}
