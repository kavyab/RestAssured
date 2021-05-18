package Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Payloadconvertor {
	public static String generatePayloadstring(String filename) throws IOException
	{
		//String filepath="C:\\Users\\KavyaBalasubramanian\\eclipse-workspace\\APIFramework\\resource\\"+filename;
		String filepath = System.getProperty("user.dir")+"\\resource\\"+filename;
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}


}
