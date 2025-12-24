package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Keyword;
import com.flipkart.base.WaitFor;

public class SigninPage {
	
	
	public SigninPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	Keyword keyword = new Keyword();

	@FindBy(xpath = "//span[text()='Sign Up']")
	WebElement signupBtn;
	
	@FindBy(xpath = "//span[text()='CONTINUE']")
	WebElement continueBtn;
	
	@FindBy(xpath = "//span[text()='Existing User? Log in']")
	WebElement existingUserlnk;
	
	@FindBy(xpath = "//span[text()='Please enter a valid Mobile number']")
	WebElement validationErrMsg;
	
	@FindBy(xpath = "//span[text()='Login']")
	WebElement logintext;
	
	
	
	public void clickContinueBtn() {
		WaitFor.elementToBeClickable(continueBtn);
		keyword.mouseHoverOn(continueBtn);
		continueBtn.click();
	}
	
	public void clickSignUp() {
		WaitFor.elementToBeClickable(signupBtn);
		keyword.mouseHoverOn(signupBtn);
		signupBtn.click();
		
	}
	
	public void clickExitingUserLnk() {
		WaitFor.elementToBeClickable(existingUserlnk);
		keyword.mouseHoverOn(existingUserlnk);
		existingUserlnk.click();
	}
	
	public boolean isContinueBtnDisplayed() {
		return keyword.isDisplayed(continueBtn);
	}
	
	public boolean isContinueBtnEnabled() {
		return keyword.isEnabled(continueBtn);
	}
	
	public boolean isExistingUserLnkDisplayed() {
		return keyword.isDisplayed(existingUserlnk);
	}
	
	public boolean isExistingUserLnkEnabled() {
		return keyword.isEnabled(existingUserlnk);
	}
	
	public boolean isErrorMessageDisplayed() {
		return keyword.isDisplayed(validationErrMsg);
	}
	
	public String getErrorMessage() {
		return validationErrMsg.getText();
	}
	
	public String getLoginText() {
		return logintext.getText();
	}

}
