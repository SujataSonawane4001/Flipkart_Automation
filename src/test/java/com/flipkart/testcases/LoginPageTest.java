package com.flipkart.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	Logger LOG = LogManager.getLogger(LoginPageTest.class);

	@Test(priority = 1,groups = "Sanity")
	public void verifyLoginButtonDisplayed() {
		LOG.info("Login Button Displayed verifies");
		HomePage homepage = new HomePage();
		homepage.isLoginLnkDisplayed();
		Boolean result = homepage.iscartIconDisplayed();
		Assert.assertTrue(result, "Login Link is not displayed on home Page");

	}

	@Test(priority = 2,groups ="Sanity")
	public void verifyUsernameTextboxDisplayed() throws InterruptedException {
		LOG.info("Username Textbox Displayed verifies");
		HomePage homepage = new HomePage();
		homepage.clickLogin();
		LoginPage login = new LoginPage();
		Thread.sleep(2000);
		Boolean result = login.isUsernametxtBoxDisplayed();
		Assert.assertTrue(result, "User text Box not displayed on login Page");

	}

	@Test(priority = 3,groups = "Regression")
	public void verifyUsernameTextboxEnabled() throws InterruptedException {
		LOG.info("Username Textbox Enabled verifies");
		HomePage homepage = new HomePage();
		homepage.clickLogin();
		LoginPage login = new LoginPage();
		Thread.sleep(2000);
		Boolean result = login.isUsernametxtBoxEnabled();
		Assert.assertTrue(result, "User text Box not enabled on login Page");
	}

	@Test(priority = 4)
	public void verifyPlaceholderTextDisplayed() {
		LOG.info("Placeholder Text Displayed verifies");
		HomePage homepage = new HomePage();
		homepage.clickLogin();
		LoginPage login = new LoginPage();
		Boolean result = login.isPlaceholderTextDsiplayed();
		Assert.assertTrue(result, "paceholder text are not displaye on login page");
	}

	@Test(priority = 5)
	public void verifyTermsOfUseNaviagtion() {
		LOG.info("TermsOfUse Naviagtion verifies");
		HomePage homepage = new HomePage();
		homepage.clickLogin();
		LoginPage login = new LoginPage();
		login.clickTermOfUse();
		login.switchWindowOnTitle("Terms Store Online");
		String title = keyword.getTitleForCurrentPage();
		System.out.println(title);
		Assert.assertEquals(title, "Terms Store Online - Buy Terms Online at Best Price in India | Flipkart.com");
	}

	@Test(priority = 6,groups = "Regression")
	public void verifyPrivacyPolicyNaviagtion() {
		LOG.info("Privacy Policy Naviagtion verifies");
		HomePage homepage = new HomePage();
		homepage.clickLogin();
		LoginPage login = new LoginPage();
		login.clickPrivacypolicy();
		login.switchWindowOnTitle("Privacypolicy Store Online");
		String title = keyword.getTitleForCurrentPage();
		Assert.assertEquals(title,
				"Privacypolicy Store Online - Buy Privacypolicy Online at Best Price in India | Flipkart.com");
	}
	
	@Test(priority = 7)
	public void verifyCreateNewUserLinkVisible() {
		LOG.info("Create NewUserLink Visible verifies");
		HomePage homepage = new HomePage();
		homepage.clickLogin();
		LoginPage login = new LoginPage();
		Boolean result = login.isCreateNewAccountLnkDsiplayed();
		Assert.assertTrue(result, "Create New User link is not displaye on login page");
     }
	
	@Test(priority = 8,groups = {"Regression","Master"})
	public void verifyCreateNewUserLinkEnabled() {
		LOG.info("CreateNewUser Link Enabled verifies");
		HomePage homepage = new HomePage();
		homepage.clickLogin();
		LoginPage login = new LoginPage();
		Boolean result = login.isCreateNewAccountLnkEnabled();
		Assert.assertTrue(result, "Create New User link is not enabled on login page");
     }
	

	@Test(priority = 9)
	public void verifyUserLogin() throws InterruptedException {
		LOG.info("UserLogin verifies");
		HomePage homepage = new HomePage();
		homepage.clickLogin();
		LoginPage login = new LoginPage();
		Thread.sleep(2000);
		login.enterUsername();
		Thread.sleep(2000);
		String btnText = login.getTextFromBtn();
		Assert.assertEquals(btnText, "Request OTP");
	}
	
	
	@Test(priority = 10)
	public void verifyCreateNewUserLinkNavigation() throws InterruptedException {
		LOG.info("Create NewUser Link Navigation verifies");
		HomePage homepage = new HomePage();
		homepage.clickLogin();
		LoginPage login = new LoginPage();
		Thread.sleep(2000);
		login.clickNewUserLink();
		String text = login.getNewUserMsg();
		Thread.sleep(3000);
		Assert.assertEquals(text, "Looks like you're new here!");
     }

}
