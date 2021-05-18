package Utility;

public class URL {
	public static final String URL = "http://rest-api.upskills.in";
	
	public static String getEndpoint()
	{
		return URL;
		
	}

	public static String getEndpoint(String resource)
	{
		return URL + resource;
		
	}

}
