package com.flipkart.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.AddToCartPage;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.SearchResultPage;

public class AddToCartTest extends TestBase {
	Logger LOG = LogManager.getLogger(AddToCartTest.class);
	
	@Test(priority = 1,groups = {"Regression","Master"})
	public void verifyAddToCartFunctionality() throws InterruptedException {
		LOG.info("AddToCart Functionality verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("tv");
		SearchResultPage searchresult = new SearchResultPage();
		searchresult.waitForProductsToLoad();
		AddToCartPage cart=new AddToCartPage();
		cart.clickProduct();
		LoginPage login=new LoginPage();
		login.switchWindowOnTitle("Online at Best Price On Flipkart.com");
		cart.clickAddToCart();
		login.switchWindowOnTitle("Shopping Cart");
		Thread.sleep(3000);
		cart.pageScrollAtbutton();
		boolean result=cart.isPlaceOrderBtnDisplayed();
		Assert.assertTrue(result,"place order button is not displayed on place order page");
	}

	@Test(priority = 2,groups = "Sanity")
	public void verifyAddToCartFunctionalityWithBuyNowOption() throws InterruptedException {
		LOG.info("AddToCart Functionality With BuyNowOption verifies");
		HomePage homepage = new HomePage();
		homepage.searchForProduct("tv");
		SearchResultPage searchresult = new SearchResultPage();
		searchresult.waitForProductsToLoad();
		AddToCartPage cart=new AddToCartPage();
		cart.clickProduct();
		keyword.switchToWindowByTitle("Online at Best Price On Flipkart.com");
		cart.clickBuyNow();
		keyword.switchToWindowByTitle("Flipkart.com: Secure Payment:");
		Thread.sleep(3000);
		boolean result=cart.isContinueBtnDisplayed();
		Assert.assertTrue(result,"continue button is not displayed on place order page");
	}

}
