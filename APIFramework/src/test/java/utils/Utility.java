package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utility {
	public static RequestSpecification req;
	public static RequestSpecification requestSpecification() throws Throwable {
		if(req==null) {
		PrintStream printStream = new PrintStream(new FileOutputStream("Logging.txt"));
		req = new RequestSpecBuilder().
				setBaseUri(getGlobal("BaseURL")).
				setContentType(ContentType.JSON).
				addFilter(RequestLoggingFilter.logRequestTo(printStream))
				.addFilter(ResponseLoggingFilter.logResponseTo(printStream))
				.addQueryParam("key", "qaclick123")
				.build();
		return req;
		}
		return req;
	}

	public static String getGlobal(String key) throws Throwable {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\APIFramework\\src\\test\\java\\utils\\global.properties");
		properties.load(fis);
	   return properties.getProperty(key);
	}
	
	public static String getJsonPath(Response reponse,String Key) {
		String reponseStr = reponse.asString();
		JsonPath json = new JsonPath(reponseStr);
		return json.getString(Key);

	}
}
