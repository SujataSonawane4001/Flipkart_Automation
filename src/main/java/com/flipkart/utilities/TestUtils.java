package com.flipkart.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {
	
	static Properties properties = new Properties();
	
	private static final String filepath = System.getProperty("user.dir") + "//src/test/resources/config.properties";
	public static String getBrowserName() throws IOException {

		FileInputStream fis = new FileInputStream(filepath);
		properties.load(fis);
		String browserName = properties.getProperty("browser_name");
		return browserName;
	}
	
	public static String getURL() throws IOException {
		FileInputStream fis = new FileInputStream(filepath);
		properties.load(fis);

		String url = properties.getProperty("url");
		System.out.println("Launched Url: " + url);
		return url;
	}


}
