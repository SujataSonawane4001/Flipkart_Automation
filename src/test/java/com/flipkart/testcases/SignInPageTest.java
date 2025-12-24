package com.flipkart.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.SigninPage;

public class SignInPageTest extends TestBase {
	Logger LOG = LogManager.getLogger(SignInPageTest.class);
	
	@Test(priority = 1,groups = "Sanity")
	public void verifySignupNavigation() throws InterruptedException {
		LOG.info("Signup Navigation verifies");
		HomePage homepage = new HomePage();
		homepage.clickOnLoginImgLink();
		SigninPage signin = new SigninPage();
		signin.clickSignUp();
		String title = keyword.getTitleForCurrentPage();
		Assert.assertEquals(title,
				"Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com");
	}

	@Test(priority = 2,groups = "Regression")
	public void verifyContinueButton() {
		LOG.info("Continue Button verifies");
		HomePage homepage = new HomePage();
		homepage.clickOnLoginImgLink();
		SigninPage signin = new SigninPage();
		signin.clickSignUp();
		Boolean result = signin.isContinueBtnDisplayed();
		Assert.assertTrue(result, "Continue button should display on signup page");

	}

	@Test(priority = 3,groups = "Regression")
	public void verifyContinueButtonEnabled() {
		LOG.info("Continue Button Enabled verifies");
		HomePage homepage = new HomePage();
		homepage.clickOnLoginImgLink();
		SigninPage signin = new SigninPage();
		signin.clickSignUp();
		Boolean result = signin.isContinueBtnEnabled();
		Assert.assertTrue(result, "Continue button should enabled on signup page");
	}

	@Test(priority = 4,groups = "Sanity")
	public void verifyExistingUserLinkIsEnabled() {
		LOG.info("Existing User Link IsEnabled verifies");
		HomePage homepage = new HomePage();
		homepage.clickOnLoginImgLink();
		SigninPage signin = new SigninPage();
		signin.clickSignUp();
		Boolean result = signin.isExistingUserLnkEnabled();
		Assert.assertTrue(result, "Existing User Link should enabled on signup page");
	}

	@Test(priority = 5,groups = "Master")
	public void verifyExistingUserLinkIsDisplayed() {
		LOG.info("Existing User Link IsDisplayed verifies");
		HomePage homepage = new HomePage();
		homepage.clickOnLoginImgLink();
		SigninPage signin = new SigninPage();
		signin.clickSignUp();
		Boolean result = signin.isExistingUserLnkDisplayed();
		Assert.assertTrue(result, "Existing User Link should diaplayed on signup page");
	}

	@Test(priority = 6)
	public void verifyExistingUserNavigation() throws InterruptedException {
		LOG.info("Existing User Navigation verifies");
		HomePage homepage = new HomePage();
		homepage.clickOnLoginImgLink();
		SigninPage signin = new SigninPage();
		signin.clickSignUp();
		signin.clickExitingUserLnk();
		String result = signin.getLoginText();
		Assert.assertEquals(result, "Login");
	}

	@Test(priority = 7,groups = "Regression")
	public void verifyValidationMessage() {
		LOG.info("Validation Message verifies");
		HomePage homepage = new HomePage();
		homepage.clickOnLoginImgLink();
		SigninPage signin = new SigninPage();
		signin.clickSignUp();
		homepage.hoverOnSearch();
		signin.clickContinueBtn();
		String result = signin.getErrorMessage();
		Assert.assertEquals(result, "Please enter a valid Mobile number");
	}

}
