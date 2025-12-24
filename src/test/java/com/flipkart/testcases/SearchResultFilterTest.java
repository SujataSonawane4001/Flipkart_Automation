package com.flipkart.testcases;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.SearchResultPage;

public class SearchResultFilterTest extends TestBase {
	Logger LOG = LogManager.getLogger(SearchResultFilterTest.class);
	
	@Test(priority = 1,groups = {"Regression","Sanity"})
	public void verifyDefaultSorting() {
		LOG.info("Default Sorting verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("mobile");
		SearchResultPage searchresult = new SearchResultPage();
		boolean result = searchresult.areSearchResultDisplayed();
		Assert.assertTrue(result, "product should be display by deault");

	}

	@Test(priority = 2)
	public void verifyResultCountIsDisplayed() {
		LOG.info("Result Count IsDisplayed verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("mobile");
		SearchResultPage searchresult = new SearchResultPage();
		String resultText = searchresult.getSearchResultText();
		Assert.assertTrue(resultText.contains("results for"), "result text should contain expected format");

	}

	@Test(priority = 3,groups = "Regression")
	public void verifySortByReleveance() {
		LOG.info("Sort ByReleveance verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("mobile");
		SearchResultPage searchresult = new SearchResultPage();
		searchresult.sortByRelevance();
		searchresult.waitForProductsToLoad();
		Assert.assertTrue(searchresult.areSearchResultDisplayed(), "product should be displayed after relevance sort");

	}

	@Test(priority = 4)
	public void verifyProductCountRemainsSameAfterSortByReleveance() {
		LOG.info("Product Count Remains Same After Sort ByReleveance verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("mobile");
		SearchResultPage searchresult = new SearchResultPage();
		searchresult.sortByRelevance();
		searchresult.waitForProductsToLoad();
		int productcount = searchresult.getNumberOfProduct();
		Assert.assertTrue(productcount > 0, "should have product after relevance sort");
	}

	@Test(priority = 5,groups = "Master")
	public void verifySortByPopularity() {
		LOG.info("Sort By Popularity verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("mobile");
		SearchResultPage searchresult = new SearchResultPage();
		searchresult.sortByPopularity();
		searchresult.waitForProductsToLoad();
		Assert.assertTrue(searchresult.areSearchResultDisplayed(), "product should be displayed after popularity sort");
	}

	@Test(priority = 6,groups = "Master")
	public void verifySortByPriceLowToHigh() throws InterruptedException {
		LOG.info("Sort By Price LowToHigh verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("mobile");
		SearchResultPage searchresult = new SearchResultPage();
		searchresult.sortByPriceLowToHigh();
		System.out.println("click on price");
		Thread.sleep(2000);
		searchresult.waitForProductsToLoad();
		System.out.println("wait for product load");
		homepage.hoverOnSearch();
		Assert.assertTrue(searchresult.areSearchResultDisplayed(), "product should be displayed after popularity sort");
		List<Integer> prices = searchresult.getAllProductPrices();
		Thread.sleep(2000);
		System.out.println(prices);
		if (prices.size() > 1) {
			Assert.assertTrue(searchresult.isPriceSortedLowToHigh(prices), "prices should be sorted from low to high");
		}

	}

//	@Test(priority = 7)
//	public void verifySortByPriceHighToLow() throws InterruptedException {
//		LOG.info("Sort By Price HighToLow verifies and found bug here");
//		HomePage homepage = new HomePage();
//		homepage.searchForProduct("mobile");
//		SearchResultPage searchresult = new SearchResultPage();
//		searchresult.sortByPriceHighToLow();
//		Thread.sleep(2000);
//		searchresult.waitForProductsToLoad();
//		homepage.hoverOnSearch();
//		Assert.assertTrue(searchresult.areSearchResultDisplayed(), "product should be displayed after popularity sort");
//		List<Integer> prices = searchresult.getAllProductPrices();
//		System.out.println(prices);
//		if (prices.size() > 1) {
//			Assert.assertTrue(searchresult.isPriceSortedHighToLow(prices), "prices should be sorted from high to low");
//		}
//
//	}
	
	@Test(priority = 7)
	public void verifySortByNewestFirst() {
		LOG.info("Sort By NewestFirst verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("mobile");
		SearchResultPage searchresult = new SearchResultPage();
		searchresult.sortByNewest();
		searchresult.waitForProductsToLoad();
		Assert.assertTrue(searchresult.areSearchResultDisplayed(), "product should be displayed after Newest first sort");
		int productCount = searchresult.getNumberOfProduct();
	   Assert.assertTrue(productCount>0, "should have product after newest first sort");

	}
	
	@Test(priority = 9,groups = "Sanity")
	public void verifyMultipleSortOperations() {
		LOG.info("Sort By Multiple Sort Operation verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("mobile");
		SearchResultPage searchresult = new SearchResultPage();
		searchresult.sortByPriceHighToLow();
		searchresult.sortByPriceLowToHigh();
		searchresult.sortByRelevance();
		Assert.assertTrue(searchresult.areSearchResultDisplayed(),"product should be displayed after multiple sort operations");
	}
	
	@Test(priority = 10)
	public void verifyProductSearchWithSecondSuggestionText() throws InterruptedException {
		LOG.info("Product Search With Second Suggestion Text verifies");
		HomePage homepage = new HomePage();
		homepage.enterProductName("laptop");
		Thread.sleep(2000);
		homepage.selectSecondProductFromSuggestion();
		SearchResultPage searchresult = new SearchResultPage();
		Assert.assertTrue(searchresult.areSearchResultDisplayed(),"product should be displayed after selecting second product from suggestion");
	}
	

}
