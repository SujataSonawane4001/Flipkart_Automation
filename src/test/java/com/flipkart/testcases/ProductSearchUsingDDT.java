package com.flipkart.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.base.Keyword;
import com.flipkart.base.TestBase;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.SearchResultPage;
import com.flipkart.utilities.DataProviders;


public class ProductSearchUsingDDT extends TestBase{
	Logger LOG = LogManager.getLogger(ProductSearchUsingDDT.class);
	
	@Test(dataProvider = "SearchData", dataProviderClass = DataProviders.class)
	public void verifySearchFunctionalityUsingDDT(String productName) {
		LOG.info("verify Search Functionality Using DDT verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct(productName);
		SearchResultPage searchresult = new SearchResultPage();
		searchresult.waitForProductsToLoad();
		
		String title=Keyword.getTitleForCurrentPage();
		Assert.assertTrue(title.toLowerCase().contains(productName.toLowerCase()), "search result page loaded for :"+productName);
	}

}
