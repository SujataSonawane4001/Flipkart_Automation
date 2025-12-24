package com.flipkart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Keyword;
import com.flipkart.base.WaitFor;

public class SearchResultPage {
	
	public SearchResultPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	Keyword keyword = new Keyword();
	
	@FindBy(xpath="//span[contains(text(),'results for')]") 
	WebElement searchResultText;
	
	@FindBy(xpath="//div[contains(text(),'Sorry')]") 
	WebElement searchResultTextErr;
	
	@FindBy(xpath="//div[@data-id]")
	List<WebElement> productItems;
	
	@FindBy(xpath="//div[contains(@class,'DlHZ')]")
	List<WebElement> productTitles;
	
	@FindBy(xpath="//div[@data-id]//div[contains(@class,'DeU9vF')] ")
	List<WebElement> productPrices;
	
	@FindBy(xpath="//div[contains(text(),'Price')]")
	WebElement priceFilter;
	
	@FindBy(xpath="//div[contains(text(),'Relevance')]")
	WebElement relevanceFilter;
	
	@FindBy(xpath="//div[contains(text(),'Popularity')]")
	WebElement popularityFilter;
	
	@FindBy(xpath="//div[contains(text(),'Price -- Low to High')]")
	WebElement lowToHighSort;
	
	@FindBy(xpath="//div[contains(text(),'Price -- High to Low')]")
	WebElement highToLowSort;
	
	@FindBy(xpath="//div[contains(text(),'Newest First')]")
	WebElement newestFirstFilter;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement nextPageLnk;
	
	@FindBy(xpath="//a[text()='2']")
	WebElement PageTwoLnk;
	
	@FindBy(xpath="//span[contains(text(),'unavailable') or contains(text(),'Out of Stock')]")
	List<WebElement> unavailableproduct;
	


	
	
	public void waitForProductsToLoad() {
		WaitFor.elementsToBeVisible(productItems);
	}
	
	public void waitForPageLoad() {
		WaitFor.untilUrlLoad("https://www.flipkart.com/search?");
	}
	
	
	public String getSearchResultText() {
		WaitFor.elementToBeVisible(searchResultText);
		return searchResultText.getText();
	}
	
	public String getSearchResultTextError() {
		WaitFor.elementToBeVisible(searchResultTextErr);
		return searchResultTextErr.getText();
	}
	
	public int getNumberOfProduct() {
		WaitFor.elementsToBeVisible(productItems);
		return productItems.size();
	}
	
	public boolean areSearchResultDisplayed() {
		return productItems.size()>0;
	}
	
	public String clickFirstProduct() {
		WaitFor.visibilityOfallElements(productTitles);
		return productTitles.get(0).getText();
	}
	
	public String getFirstProductPrice() {
		WaitFor.visibilityOfallElements(productPrices);
		return productTitles.get(0).getText();
	}
	
	
	public void sortByPriceHighToLow() {
		WaitFor.elementToBeClickable(highToLowSort);
		highToLowSort.click();
		waitForProductsToLoad();
	}
	
	public void sortByPriceLowToHigh() {
		WaitFor.elementToBeClickable(lowToHighSort);
		lowToHighSort.click();
		waitForProductsToLoad();
	}
	
	public void goToNextPage() {
		WaitFor.elementToBeClickable(nextPageLnk);
		nextPageLnk.click();
		waitForProductsToLoad();
	}
	
	public void sortByRelevance() {
		WaitFor.elementToBeClickable(relevanceFilter);
		relevanceFilter.click();
		waitForProductsToLoad();
	}
	
	public void sortByPopularity() {
		WaitFor.elementToBeClickable(popularityFilter);
		popularityFilter.click();
		waitForProductsToLoad();
	}
	
	public void sortByNewest() {
		WaitFor.elementToBeClickable(newestFirstFilter);
		newestFirstFilter.click();
		waitForProductsToLoad();
	}
	
	public void goToPageTwo() {
		WaitFor.elementToBeClickable(PageTwoLnk);
		PageTwoLnk.click();
		waitForProductsToLoad();
	}
	
	
	
	
	public List<Integer> getAllProductPrices() {
		WaitFor.visibilityOfallElements(productPrices);
		List<WebElement> productPricess=keyword.getListOfWebElements(productPrices);
		List<Integer> prices=new ArrayList<>();
		for (WebElement priceElement : productPricess) {
			try {
				String priceText=priceElement.getText();
				
				//remove non numeric character
				String numericprice=priceText.replaceAll("[^0-9]","");
				if(!numericprice.isEmpty()) {
					prices.add(Integer.parseInt(numericprice));
				}
			}catch(NumberFormatException e) {
				System.out.println("could not parse price"+ priceElement.getText());
			}
			
		}
		return prices;
	}
	
	public boolean isPriceSortedLowToHigh(List<Integer> prices) {
		if(prices.size()<2) {
			return true;  //if no price is sorted
		}
		
		for (int i = 0; i < prices.size()-1; i++) {
			if(prices.get(i)>prices.get(i+1)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public boolean isPriceSortedHighToLow(List<Integer> prices) {
		if(prices.size()<2) {
			return true;  //if no price is sorted
		}
		
		for (int i = 0; i < prices.size()-1; i++) {
			if(prices.get(i)<prices.get(i+1)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
	
	
	

}
