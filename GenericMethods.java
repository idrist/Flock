package com.flock.utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

public class GenericMethods {
	private WebDriver driver;
	
	private static final Logger logger = Logger.getLogger(GenericMethods.class);

	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(String locator, String type) {
		WebElement element = null;
		type = type.toLowerCase();
		if (type.equals("id")) {
			logger.debug("Searching element using By.id(" + locator + ")");
			element = this.driver.findElement(By.id(locator));
		} else if (type.equals("xpath")) {
			logger.debug("Searching element using By.xpath(" + locator + ")");
			element = this.driver.findElement(By.xpath(locator));
		} else if (type.equals("css")) {
			logger.debug("Searching element using By.cssSelector(" + locator + ")");
			element = this.driver.findElement(By.cssSelector(locator));
		} else if (type.equals("linktext")) {
			logger.debug("Searching element using By.linkText(" + locator + ")");
			element = this.driver.findElement(By.linkText(locator));
		} else if (type.equals("partiallinktext")) {
			logger.debug("Searching element using By.partialLinkText(" + locator + ")");
			element = this.driver.findElement(By.partialLinkText(locator));
		} else if (type.equals("classname")) {
			logger.debug("Searching element using By.className(" + locator + ")");
			element = this.driver.findElement(By.className(locator));
		} else if (type.equals("name")) {
			logger.debug("Searching element using By.name(" + locator + ")");
			element = this.driver.findElement(By.name(locator));
		} else if (type.equals("tagname")) {
			logger.debug("Searching element using By.tagName(" + locator + ")");
			element = this.driver.findElement(By.tagName(locator));
		} else {
			logger.debug("Locator type not supported");
		}
		if (element != null) {
			logger.info("Element not found with " + type + ": " + locator);
		} else {
			logger.info("Element found with " + type + ": " + locator);
		}
		return element;
	}

	public List<WebElement> getElementList(String locator, String type) {
		type = type.toLowerCase();
		List<WebElement> webElementList = new ArrayList<WebElement>();
        logger.debug("Type: " + type + ", Locator: " + locator);
        if (type.equals("id")) {
            logger.debug("Searching element list using By.id(" + locator + ")");
            webElementList = this.driver.findElements(By.id(locator));
        } else if (type.equals("xpath")) {
            logger.debug("Searching element list using By.xpath(" + locator + ")");
            webElementList = this.driver.findElements(By.xpath(locator));
        } else if (type.equals("css")) {
            logger.debug("Searching element list using By.cssSelector(" + locator + ")");
            webElementList = this.driver.findElements(By.cssSelector(locator));
        } else if (type.equals("linktext")) {
            logger.debug("Searching element list using By.linkText(" + locator + ")");
            webElementList = this.driver.findElements(By.linkText(locator));
        } else if (type.equals("partiallinktext")) {
            logger.debug("Searching element list using By.partialLinkText(" + locator + ")");
            webElementList = this.driver.findElements(By.partialLinkText(locator));
        } else if (type.equals("classname")) {
            logger.debug("Searching element list using By.className(" + locator + ")");
            webElementList = this.driver.findElements(By.className(locator));
        } else if (type.equals("name")) {
            logger.debug("Searching element list using By.nam(" + locator + ")");
            webElementList = this.driver.findElements(By.name(locator));
        } else if (type.equals("tagname")) {
            logger.debug("Searching element list using By.tagName(" + locator + ")");
            webElementList = this.driver.findElements(By.tagName(locator));
        } else {
            logger.debug("Locator type not supported");
            return null;
        }
        if (webElementList.isEmpty()) {
            logger.info("Element not found with " + type + ": " + locator);
        } else {
            logger.info("Element found with " + type + ": " + locator);
        }
        return webElementList;
    }

	public boolean isElementPresent(String locator, String type) {
		List<WebElement> getElementList = getElementList(locator, type);
		int size = getElementList.size();
		logger.info("The size of the element list is "+size);
		if (size > 0) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement waitForElement(By locator, int timeout) {
		WebElement element = null;
		try {
			logger.info("Waiting for a max: " + timeout + " sec for the element to appear");
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			logger.info("The Element that you waited for is now displayed on the webpage");
		} catch (Exception e) {
			logger.error("The Element that you waited for is not displayed on the webpage");
		}
		return element;
	}

	public void click(By locator, int timeout) {

		try {
			WebElement element = null;
			logger.info("Waiting for a max: " + timeout + " sec for the element to be clickable");
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			logger.info("Element clicked on the webpage");
		} catch (Exception e) {
			logger.error("Element not clicked on the webpage");
		}
	}

	public void SendKey(By locator, int timeout, String text) {
		try {
			WebElement element = null;
			logger.info("Waiting for a max: " + timeout + " sec for the element to be send key");
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element.sendKeys(text);
			logger.info("Value Entered in the place holder");
		} catch (Exception e) {
			logger.error("Element not displayed on the webpage");
		}
	}

	public void getTitle() {
		String Title = driver.getTitle();
		logger.info("The title of the Page is: " + Title);
		if (driver.getPageSource().contains(Title)) {
			logger.info("The Title is Correct");
		} else {
			logger.error("The Title is InCorrect");
		}
	}

	public void switchToiFrame(String value) {
		driver.switchTo().frame(value);
		logger.info("Switched to iframe by value : " + value);
	}

	public void SwitchToiFrameNo(int value) {
		driver.switchTo().frame(value);
		logger.info("Switched to iframe by int : " + value);
	}

	public void maximize() {
		driver.manage().window().maximize();
		logger.info("Browser Window Maximized");
	}

	public boolean pageSourceContains(String text) {
		if (driver.getPageSource().contains(text)) {
			logger.info("The Page Source is Fetched");
			return true;
		} else {
			logger.error("The Page Source could not be Fetched");
			return false;
		}
	}

	public boolean elementDisplayed(By Locator, String elementName) {
		WebElement element = driver.findElement(Locator);
		if (element.getSize() != null) {
			logger.info("The " + elementName + " element at loction: " + Locator + " is displayed");
			return true;
		} else {
			logger.error("The " + elementName + " element at loction: " + Locator + " is displayed");
			return false;
		}
	}

	/*
	 * public boolean elementIsDisplayed(By locator) { boolean display =
	 * driver.findElement(locator).isDisplayed(); if (display) {
	 * log.info("The element: " + locator + " is displayed."); return true; }
	 * else { log.error("The element: " + locator + " is NOT displayed.");
	 * return false; } }
	 */

	public void navigateBack() {
		driver.navigate().back();
	}

	public void clearField(By locator) {
		WebElement field = driver.findElement(locator);
		field.clear();
		logger.info("The field is cleared");
	}

	public void getText(By locator) {
		String Text = driver.findElement(locator).getText();
		logger.info("THe text at locator: " + locator + " is " + Text);
	}

	public void getInnerText(By locator) {
		String Text = driver.findElement(locator).getAttribute("innerText");
		logger.info("THe text at locator: " + locator + " is " + Text);
	}

	public boolean compareText(By locator, String vdkText) {
		String Text = driver.findElement(locator).getText();
		if (vdkText.contains(Text)) {
			logger.info("The text: " + Text + " displayed is correct");
			return true;
		} else {
			logger.error("The text: " + Text + " displayed is not correct");
			return false;
		}
	}
	
	public boolean compareString(String scriptText, String vdkText) {
		
		if (vdkText.contains(scriptText)) {
			logger.info("The text: " + scriptText + " displayed is correct");
			return true;
		} else {
			logger.error("The text: " + scriptText + " displayed is not correct");
			return false;
		}
	}

	public WebElement switchToHandle(String handleName) {
		logger.info("Switching the window handle to " + handleName);
		return (WebElement) driver.switchTo().window(handleName);
	}

	public Set<String> getHandles() {
		return driver.getWindowHandles();
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		logger.info("Implicitly waiting for " + time + "secs");
	}

	public void radioButtonIterate(By locator) throws Exception {
		boolean isChecked = false;
		List<WebElement> radioButtons = driver.findElements(locator);
		int size = radioButtons.size();
		logger.info("Size of the list: " + size);
		for (int i = 0; i < size; i++) {
			isChecked = radioButtons.get(i).isSelected();
			if (isChecked) {
				WebElement element = driver.findElement(locator);
				if (element.getSize() != null) {
					logger.info("The element at loction: " + locator + " is displayed");
				} else {
					logger.error("The element at loction: " + locator + " is displayed");
				}
				String Text = driver.findElement(locator).getText();
				logger.info("THe text at locator: " + locator + " is " + Text);
				if (driver.getPageSource().contains(Text)) {
					logger.info("The text: " + Text + " displayed is correct");
				} else {
					logger.error("The text: " + Text + " displayed is not correct");
				}
				Thread.sleep(2000);
			} else {
				radioButtons.get(i).click();
				WebElement element = driver.findElement(locator);
				if (element.getSize() != null) {
					logger.info("The element at loction: " + locator + " is displayed");
				} else {
					logger.error("The element at loction: " + locator + " is displayed");
				}
				String Text = driver.findElement(locator).getText();
				logger.info("THe text at locator: " + locator + " is " + Text);
				if (driver.getPageSource().contains(Text)) {
					logger.info("The text: " + Text + " displayed is correct");
				} else {
					logger.error("The text: " + Text + " displayed is not correct");
				}
			}
		}
	}
public void selectElement(By locator){
	
}
	public void webelementsText(By locator) {

		List<WebElement> options = driver.findElements(locator);
		int size = options.size();

		for (int i = 0; i < size; i++) {
			String optionName = options.get(i).getText();
			logger.info("The option in the drop down is: " + optionName);
		}
	}
	
	public void waitAndClick(By locator, long timeoutInSeconds) {
        try {
            logger.debug("Waiting for a max: " + timeoutInSeconds + " seconds for the element to become " +
                    "clickable");
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            logger.info("Element clicked on the web page");
        } catch (Exception e) {
            logger.info("Not able to waitAndClick on the element");
        }
    }
	
	public static int getResponseCode(String url) throws MalformedURLException, IOException{
	    HttpURLConnection.setFollowRedirects(true);
	    HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
	    con.setConnectTimeout(2);
	    con.setRequestMethod("GET");
	    int responseCode = con.getResponseCode();
	    		if(con != null){
	        con.disconnect();
	    }
	    return responseCode;
	}
}
