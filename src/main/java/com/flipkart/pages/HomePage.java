package com.flipkart.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Keyword;
import com.flipkart.base.WaitFor;

public class HomePage{

	public HomePage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	Keyword keyword = new Keyword();

	@FindBy(xpath = "//img[@title='Flipkart']")
	WebElement logoicon;

	@FindBy(xpath = "//input[@name='q']")
	WebElement searchBox;
	
	@FindBy(xpath="//input[@placeholder='Search for Products, Brands and More']")
	WebElement searchPlaceholder;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBtn;

	@FindBy(xpath = "//span[text()='Login']")
	WebElement loginLink;

	@FindBy(xpath = "//img[@alt='Cart']")
	WebElement cartIcon;

	@FindBy(xpath = "//a[text()='Become a Seller']")
	WebElement becomeSellerlnk;

	@FindBy(xpath = "//span[text()='Grocery']")
	WebElement grocery;

	@FindBy(xpath = "//span[contains(text(),'Fashion')]")
	WebElement Fashion;

	@FindBy(xpath = "//span[text()='Electronics']")
	WebElement electronics;

	@FindBy(xpath = "//span[text()='Mobiles & Tablets']")
	WebElement mobiles;

	@FindBy(xpath = "//span[text()='Home & Furniture']")
	WebElement homeFurniture;
	
	@FindBy(xpath="//a[text()='Women Ethnic']") 
	WebElement womenEthnic;
	
	@FindBy(xpath="//a[text()='Laptop and Desktop']") 
	WebElement laptops;
	
	@FindBy(xpath="//a[text()='Living Room Furniture']") 
	WebElement livingRoom;
	
	@FindBy(xpath="//span[contains(text(),'Showing 1 – 24 of ')]//span")
	WebElement resultName;
	
	@FindBy(xpath="//ul[1]//li//span")
	List<WebElement> listOfSuggestion;
	
	@FindBy(xpath="(//ul//li)[2]//a//div[2]")
	WebElement SuggestionBoxSecondProduct;
	
	@FindBy(xpath = "(//a[@title='Login'])[1]/following-sibling::img")
	WebElement loginImgLink;
	
	
	
//	public void closeLoginModal() {
//		try {
//			WaitFor.elementToBeClickable(Fashion);
//		}catch(Exception e) {
//			System.out.println("login popup not present and alredy closed");
//		}
//	}
	
	public void WaitForProductListLoad() {
		
		WaitFor.visibilityOfallElements(listOfSuggestion);
	}
	
	public boolean isLogoDisplayed() {
		return keyword.isDisplayed(logoicon);
    }
	
	public boolean isLoginLnkDisplayed() {
		return keyword.isDisplayed(loginLink);
    }
	
	public void clickLogin() {
		keyword.mouseHoverOn(loginLink);
		loginLink.click();
	}
	
	public void clickOnLoginImgLink() {
		keyword.mouseHoverOn(loginLink);
		loginImgLink.click();
		
	}
	
	public void clickCart() {
		cartIcon.click();
	}
	
	public void clickBecomeSeller() {
		becomeSellerlnk.click();
	}
	
	public void clickCategoryGrocery() {
		WaitFor.elementToBeVisible(grocery);
		grocery.click();
	}
	
	public void hoverOnFashion() {
	    keyword.mouseHoverOn(Fashion);
	}
	
	public void hoverOnElectronics() {
		keyword.mouseHoverOn(electronics);
	}
	
	public void hoverOnMobiles() {
		keyword.mouseHoverOn(mobiles);
	}
	
	public void hoverOnFurniture() {
		keyword.mouseHoverOn(homeFurniture);
	}
	
	public void clickLaptops() {
		laptops.click();
	}
	
    public void clickWomenEthnic() {
		womenEthnic.click();
	}
    
    public void clickLivingRoom() {
		livingRoom.click();
   	}
    
    public boolean isSearchBoxEnabled() {
		return keyword.isEnabled(searchBox);
    }
    
    public boolean iscartIconDisplayed() {
		return keyword.isDisplayed(cartIcon);
    }
	
	public void enterSearchTerm(String productName) {
		WaitFor.elementToBeVisible(searchBox);
		searchBox.clear();
		searchBox.sendKeys(productName);
		
	}
	
	public void hoverOnSearch() {
	    keyword.mouseHoverOn(searchBtn);
	}
	
	
	public void clickSearchButton() {
		searchBtn.click();
	}
	
	public void pressEnterToSearch() {
		searchBox.sendKeys(Keys.ENTER);
	}
	
	public void searchForProduct(String productName) {
		enterSearchTerm(productName);
		keyword.mouseHoverOn(searchBox);
		pressEnterToSearch();
	}
	
	public void searchForProductUsingEnter(String productName) {
		enterSearchTerm(productName);
		keyword.mouseHoverOn(searchBtn);
		clickSearchButton();
	}
	
	public String getSearchPlaceholderText() {
		return searchBox.getAttribute("placeholder");
	}
	
	public Boolean isPlaceholderTextDsiplayed() {
		return searchPlaceholder.isDisplayed();
	}
	
	public Boolean isResultTitleDisplayed() {
		return resultName.isDisplayed();
	}
	
	public String getSearchResultTitleText() {
		return resultName.getText();
	}
	
	public void enterProductName(String productName) {
		WaitFor.elementToBeVisible(searchBox);
		searchBox.sendKeys(productName);
		WaitForProductListLoad();
		
	}
	
	public void selectSecondProductFromSuggestion() {
		WaitForProductListLoad();
		keyword.mouseHoverOn(SuggestionBoxSecondProduct);
		WaitFor.elementToBeClickable(SuggestionBoxSecondProduct);
		SuggestionBoxSecondProduct.click();
	}
	
	
	
	
}
