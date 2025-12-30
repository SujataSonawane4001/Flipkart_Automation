package com.flipkart.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class Keyword {

	public static RemoteWebDriver driver;
	private static final Logger LOG = LogManager.getLogger(Keyword.class);

	public void openBrowser(String browserName) {
		if (browserName == null) {
			LOG.info("Launching Chrome by default");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			LOG.info("Launching Chrome browser");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			LOG.info("Launching firefox browser");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			LOG.info("Launching edge browser");
			driver = new EdgeDriver();
		} else {
			LOG.info("Invalid browser name");
		}

		System.out.println("Launched " + browserName + " browser");

	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void clickOn(WebElement element) {
		element.click();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit(); // This properly closes the browser and ends the WebDriver session
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void print(String string) {
		System.out.println(string);
	}

	public static void sendkeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	public static void sendKeys(WebElement element, Keys enter) {
		element.sendKeys(enter);

	}

	public static String getTitleForCurrentPage() {
		String currentPageTitle = driver.getTitle();
		return currentPageTitle;

	}

	public static void verifyNavigation(String expectedTitle) {
		String actualTitle = Keyword.getTitleForCurrentPage();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	public void mouseHoverOn(WebElement element) {
		Actions actions = new Actions(Keyword.driver);
		actions.moveToElement(element).perform();
	}

	public static void refreshPage() {
		driver.navigate().refresh();
	}

	public void deletecookies() {
		driver.manage().deleteAllCookies();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public Boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	public Boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public void pageScrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView[true];", element);
	}

	public static List<WebElement> getListOfWebElements(List<WebElement> elements) {
		WaitFor.visibilityOfallElements(elements);
		return elements;

	}

	public void switchToWindowByTitle(String expectedTitleSubstring) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String handle : allWindows) {
			String currentTitle = driver.switchTo().window(handle).getTitle();
			if (currentTitle.contains(expectedTitleSubstring)) {
				System.out.println("Switched to window with title: " + currentTitle);
				break;
			}
		}
	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String randomAlphaNumeric() {
		String generatedString = RandomStringUtils.randomNumeric(3);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return (generatedString + "@" + generatedNumber);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);
		return targetFilePath;

	}

}
