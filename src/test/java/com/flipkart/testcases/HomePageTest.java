package com.flipkart.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.base.Keyword;
import com.flipkart.base.TestBase;
import com.flipkart.base.WaitFor;
import com.flipkart.pages.HomePage;

public class HomePageTest extends TestBase {
	
	Logger LOG = LogManager.getLogger(HomePageTest.class);
	
	@Test(priority = 1,groups = "Regression")
	public void verifyLogoDisplayed() {
		LOG.info("Logo verifies");
		HomePage homepage=new HomePage();
		Boolean result=homepage.iscartIconDisplayed();
		Assert.assertTrue(result,"Flipkart logo is not displayed on home Page");
	}
	
	@Test(priority = 2)
	public void verifyLoginButton() {
		LOG.info("LoginButton verifies");
		HomePage homepage=new HomePage();
		homepage.clickLogin();
		String title=keyword.getTitleForCurrentPage();
		Assert.assertEquals(title,"Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com");
	
	}
	
	@Test(priority = 3,groups = "Regression")
	public void verifyBecomeSellerNavigation() {
		LOG.info("BecomeSeller Navigation verifies");
		HomePage homepage=new HomePage();
		homepage.clickBecomeSeller();
		String url=keyword.getCurrentUrl();
		Assert.assertTrue(url.contains("seller"), "Url does not contain seller");
	}
	
	@Test(priority = 4)
	public void verifyGroceryCategoryNavigation() {
		LOG.info("Grocery Category Navigation verifies");
		HomePage homepage=new HomePage();
		homepage.clickCategoryGrocery();
		String title=keyword.getTitleForCurrentPage();
		Assert.assertEquals(title,"Flipkart Kilos: Online Grocery Store with Up to 80% OFF");
		
	}
	
	@Test(priority = 5)
	public void verifyFashionSubCategoryNavigation() {
		LOG.info("Fashion SubCategory Navigation verifies");
		HomePage homepage=new HomePage();
		homepage.hoverOnFashion();
		homepage.clickWomenEthnic();
		Assert.assertTrue(keyword.getTitleForCurrentPage().toLowerCase().contains("saree"),"KK,Sets,DM,Sarees - Buy KK,Sets,DM,Sarees Online at Low Prices In India | Flipkart.com");
	
	}
	
	
	@Test(priority = 6)
	public void verifyElectronicsSubCategoryNavigation() {
		LOG.info("Electronics SubCategory Navigation verifies");
		HomePage homepage=new HomePage();
		homepage.hoverOnElectronics();
		homepage.clickLaptops();
		Assert.assertTrue(keyword.getTitleForCurrentPage().toLowerCase().contains("laptops"),"Laptops Online - Budget Laptops at Best Prices in India at Flipkart");
	
	}
	
	@Test(priority = 7)
	public void verifyFurnitureSubCategoryNavigation() {
		LOG.info("Furniture SubCategory Navigation verifies");
		HomePage homepage=new HomePage();
		homepage.hoverOnFurniture();
		homepage.clickLivingRoom();
		Assert.assertTrue(keyword.getTitleForCurrentPage().toLowerCase().contains("furniture"),"Furniture India Ka Furniture Livingroom Store Online - Buy Furniture India Ka Furniture Livingroom Online at Best Price in India | Flipkart.com");
	
	}
	
	@Test(priority = 8,groups = "Regression")
	public void verifyHomePageTitle() {
		LOG.info("HomePage Title verifies");
		HomePage homepage=new HomePage();
		String title=keyword.getTitleForCurrentPage();
		Assert.assertTrue(title.toLowerCase().contains("flipkart"),"Online Shopping India Mobile, Cameras, Lifestyle & more Online @ Flipkart.com");
	
	}
	
	@Test(priority = 9)
	public void verifySearchBoxEnabled() {
		LOG.info("SearchBox Enabled verifies");
		HomePage homepage=new HomePage();
		Boolean result=homepage.isSearchBoxEnabled();
		Assert.assertTrue(result,"search box is not enabled on home Page");
	
	}
	
	@Test(priority = 10,groups = "Sanity")
	public void verifycartIconVisible() {
		LOG.info("cartIcon Visible verifies");
		HomePage homepage=new HomePage();
		Boolean result=homepage.iscartIconDisplayed();
		Assert.assertTrue(result,"cart icon is not displayed on home Page");
	}
	
	@Test(priority = 11,groups = "Sanity")
	public void verifyAbletoSerachProduct() {
		LOG.info("Able to Serach Product verifies");
		HomePage homepage=new HomePage();
		homepage.searchForProduct("mobile");
		Boolean result=homepage.isResultTitleDisplayed();
		Assert.assertTrue(result,"product title not displayed on result Page");
		
	}
	
	
	
}
