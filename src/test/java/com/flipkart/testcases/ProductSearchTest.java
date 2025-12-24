package com.flipkart.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.SearchResultPage;

public class ProductSearchTest extends TestBase {

	 Logger LOG = LogManager.getLogger(ProductSearchTest.class);

	@Test(priority = 1)
	public void verifyValidProductSearch() {
		LOG.info("Valid Product Search verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("iphone15");
		Boolean result = homepage.isResultTitleDisplayed();
		Assert.assertTrue(result, "product title not displayed on result Page");
	}

	@Test(priority = 2)
	public void verifyProductSearchResultDisplay() {
		LOG.info("Product Search Result Display verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("iphone15");
		SearchResultPage searchresult = new SearchResultPage();
		boolean result = searchresult.areSearchResultDisplayed();
		Assert.assertTrue(result, "product not displayed on result Page");
	}

	@Test(priority = 3)
	public void verifyProductSearchUsingEnterKey() {
		LOG.info("Product Search Using EnterKey verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProductUsingEnter("laptop");
		SearchResultPage searchresult = new SearchResultPage();
		boolean result = searchresult.areSearchResultDisplayed();
		Assert.assertTrue(result, "No search result displayed when searching with enter key");
	}

	@Test(priority = 4)
	public void verifyEmptySearch() {
		LOG.info("Empty Search verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct(" ");
		String currentURL = keyword.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("flipkart"), "empty search redirected to unexpected page");
	}

	@Test(priority = 5)
	public void verifyProductSearchWithSpecialCharacter() {
		LOG.info("Product Search With Special Character verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("@%#$");
		SearchResultPage searchresult = new SearchResultPage();
		String resultText = searchresult.getSearchResultTextError();
		Assert.assertTrue(resultText.contains("result for") || resultText.contains("Sorry"),
				"special character search didn't return expected response");
	}

	@Test(priority = 6)
	public void verifyProductSearchWithLongText() {
		LOG.info("Product Search With LongText verifies");
		String longText = "s".repeat(100);
		HomePage homepage = new HomePage();
		homepage.searchForProduct(longText);
		Assert.assertTrue(keyword.getCurrentUrl().contains("flipkart.com"),
				"Long search query caused unexpected behaviour");
	}

	@Test(priority = 7)
	public void verifyProductSearchWithNumber() {
		LOG.info("Product Search With Number verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("12457826");
		SearchResultPage searchresult = new SearchResultPage();
		String resultText = searchresult.getSearchResultText();
		Assert.assertTrue(resultText.contains("results for"),
				"number search didn't return expected response");
	}
	
	@Test(priority = 8)
	public void verifyProductWithMultipleSearch() {
		LOG.info("Product With Multiple Search verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("gaming keyboard mouse");
		SearchResultPage searchresult = new SearchResultPage();
		boolean result=searchresult.areSearchResultDisplayed();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 9)
	public void verifyProductSearchIncaseSensitive() {
		LOG.info("Product Search In case Sensitive verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("lApToP");
		SearchResultPage searchresult = new SearchResultPage();
		boolean result=searchresult.getNumberOfProduct()>0;
		Assert.assertTrue(result);
	}
	
	@Test(priority = 10)
	public void verifyPlaceholderTextIsDisplayedWhenTheSearchBarIsEmpty() {
		LOG.info("Product Search In case Sensitive verifies");
		HomePage homepage = new HomePage();
		boolean result= homepage.isPlaceholderTextDsiplayed();
		System.out.println(result);
		Assert.assertTrue(result);
		
	}
	
	@Test(priority = 11)
	public void verifyProductSearchWithPartialText() {
		LOG.info("Product Search With Partial Text verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("mob");
		SearchResultPage searchresult = new SearchResultPage();
		String resultText = searchresult.getSearchResultText();
		Assert.assertTrue(resultText.contains("results for"),
				"number search didn't return expected response");
		
	}
	
	
	

	
	

}
