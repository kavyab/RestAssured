package Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class TestUtil {
	//To convert to String
		public static String getResponseString(Response response)
		{
			String strres = response.getBody().asString();
			return strres;
		}
		
		public static JsonPath jsonparser(String response)
		{
			JsonPath jsonres = new JsonPath(response);
			return jsonres;
			
		}
		
		public static XmlPath xmlparser(String response)
		{
			XmlPath xmlres = new XmlPath(response);
			return xmlres;
			
		}
		
		public static int getStatusCode(Response response)
		{
			int status =response.getStatusCode();
			return status;
			
		}
		
		public static String getStatusMessage(Response response)
		{
			String message = response.getStatusLine();
			return message;
			
		}

}
