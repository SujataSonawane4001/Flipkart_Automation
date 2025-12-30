package com.flipkart.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.flipkart.utilities.TestUtils;



public class TestBase {
	
	
	public Keyword keyword = new Keyword();
	
	@BeforeMethod(groups= {"Sanity","Regression","Master"})
	@Parameters("browser-name")
	public void setUp(@Optional("") String xmlBrowser) throws Exception {
		
		if (!xmlBrowser.isEmpty()) {
			keyword.openBrowser(xmlBrowser);
			
		} else {
			keyword.openBrowser(TestUtils.getBrowserName());
			
		}
		keyword.deletecookies();
		keyword.launchUrl(TestUtils.getURL());
		keyword.maximizeBrowser();
	}

	@Parameters("browser-name")
	@AfterMethod(groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		keyword.quitBrowser();
	}


}
