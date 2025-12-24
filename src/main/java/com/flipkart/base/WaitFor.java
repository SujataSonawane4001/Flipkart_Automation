package com.flipkart.base;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;




public class WaitFor {
	public static FluentWait<RemoteWebDriver> wait;
	public static WebDriverWait wait1;

	static {
		wait = new FluentWait<RemoteWebDriver>(Keyword.driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
		wait1 = new WebDriverWait(Keyword.driver, Duration.ofSeconds(20));
		wait1.ignoring(ElementNotInteractableException.class);

	}

	public static void elementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void stalenessRemoval(WebElement element) {
		wait.until(ExpectedConditions.stalenessOf(element));

	}

	public static void elementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void elementsToBeVisible(List<WebElement> elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	// Wait until all elements are visible
	public static List<WebElement> visibilityOfallElements(List<WebElement> elements) {
		try {
			wait1.until(ExpectedConditions.visibilityOfAllElements(elements));
			return elements;
		} catch (StaleElementReferenceException e) {
			wait1.until(ExpectedConditions.visibilityOfAllElements(elements));
			return elements;
		}
	}
	
	 public static void untilUrlLoad(String url) {
			WebDriverWait wait1 = new WebDriverWait(Keyword.driver, Duration.ofSeconds(10));
			wait1.until(ExpectedConditions.urlContains(url));

		}

}
