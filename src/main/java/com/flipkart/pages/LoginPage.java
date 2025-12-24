package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Keyword;
import com.flipkart.base.WaitFor;

public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	Keyword keyword = new Keyword();
	
	@FindBy(xpath="//input[@class='c3Bd2c yXUQVt']")
	WebElement txtusername;
	
	@FindBy(xpath="//span[text()='Enter Email/Mobile number']")
	WebElement usernamePlaceholder;
	
	@FindBy(xpath="//button[text()='Request OTP']")
	WebElement requestOtpBtn;
	
	@FindBy(xpath="//a[text()='Terms of Use']")
	WebElement TermOfUselnk;
	
	@FindBy(xpath="//a[text()='Privacy Policy']")
	WebElement privacyPolicylnk;
	
	@FindBy(xpath="//a[text()='New to Flipkart? Create an account']")
	WebElement createNewUserlnk;
	
	@FindBy(xpath="//span[(@class='iq0fCx')]//span")
	WebElement newUserMsg;
	
	
	
	public void enterUsername() {
		WaitFor.elementToBeVisible(txtusername);
		txtusername.sendKeys(keyword.randomNumber());
	}
	
	public boolean isUsernametxtBoxEnabled() {
		keyword.mouseHoverOn(txtusername);
		return keyword.isEnabled(txtusername);
	}
	
	public boolean isUsernametxtBoxDisplayed() {
		keyword.mouseHoverOn(txtusername);
		return keyword.isDisplayed(txtusername);
	}
	
	public String getSearchPlaceholderText() {
		return usernamePlaceholder.getAttribute("text");
	}
	
	public Boolean isPlaceholderTextDsiplayed() {
		return keyword.isDisplayed(usernamePlaceholder);
	}
	
	public Boolean isReaquestOtpBtnDsiplayed() {
		return keyword.isDisplayed(requestOtpBtn);
	}
	
	public String getTextFromBtn() {
		WaitFor.elementToBeVisible(requestOtpBtn);
		return requestOtpBtn.getText();
	}
	
	public void clickTermOfUse() {
		TermOfUselnk.click();
	}
	
	public void clickPrivacypolicy() {
		privacyPolicylnk.click();
	}
	
	public void clickNewUserLink() {
		keyword.mouseHoverOn(createNewUserlnk);
		createNewUserlnk.click();
	}
	
	public void switchWindowOnTitle(String Title) {
		keyword.switchToWindowByTitle(Title);
	}
	
	public Boolean isCreateNewAccountLnkDsiplayed() {
		return keyword.isDisplayed(createNewUserlnk);
	}
	
	public boolean isCreateNewAccountLnkEnabled() {
		return keyword.isEnabled(createNewUserlnk);
	}
	
	public String getNewUserMsg() {
		return newUserMsg.getText();
	}
	

}
