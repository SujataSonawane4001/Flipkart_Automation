package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Keyword;
import com.flipkart.base.WaitFor;

public class AddToCartPage {
	
	public AddToCartPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	Keyword keyword = new Keyword();
	
	@FindBy(xpath="//div[contains(@class,'col col-7-12')]//div[@class='RG5Slk']")
	WebElement productTitle;
	
   @FindBy(xpath="//button[text()='Add to cart']")
	WebElement addToCartBtn;
   
   @FindBy(xpath="//span[text()='Place Order']")
   WebElement placeOrederBtn;
   
   @FindBy(xpath="//button[text()='Buy Now']")
   WebElement buyNowBtn;
   
   @FindBy(xpath="//span[text()='CONTINUE']")
   WebElement continueBtn;
	
   @FindBy(xpath="//span[text()='Currently unavailable']")
   WebElement productNotAvailabletxt;
	
	public void clickProduct() {
		productTitle.click();
	}
	
	
	public void clickAddToCart() {
		WaitFor.elementToBeClickable(addToCartBtn);
		keyword.mouseHoverOn(addToCartBtn);
		addToCartBtn.click();
	}
	
	public void clickBuyNow() {
		WaitFor.elementToBeClickable(buyNowBtn);
		keyword.mouseHoverOn(buyNowBtn);
		buyNowBtn.click();
	}
	
	public boolean isContinueBtnDisplayed() {
		WaitFor.elementToBeVisible(continueBtn);
		keyword.mouseHoverOn(continueBtn);
		return keyword.isDisplayed(continueBtn);
	}
	
	public boolean isPlaceOrderBtnDisplayed() {
		WaitFor.elementToBeVisible(placeOrederBtn);
		keyword.mouseHoverOn(placeOrederBtn);
		return keyword.isDisplayed(placeOrederBtn);
	}
	
	public void pageScrollAtbutton() {
		WaitFor.elementToBeClickable(placeOrederBtn);
		keyword.pageScrollDown(placeOrederBtn);
	}
	
	public boolean getTextProductUnavaliable() {
		return productNotAvailabletxt.isDisplayed();
	}
	
	
	
	
	
}
