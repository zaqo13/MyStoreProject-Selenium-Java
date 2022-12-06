package com.mystore.utility;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utility  {
	
	
	public WebElement waitForVisibilityOf(WebDriver driver, WebElement element, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	
	public WebElement waitForClickable(WebDriver driver, WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void actionsMoveTo(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	public void actionsClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}
	
	
	public boolean elementIsDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
		}
		return flag;
	}
	
	
	public boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		ele.isDisplayed();
		flag = true;
		return flag;
	}
	
	
	public WebElement fluentWait(WebDriver driver, WebElement element, int timeout, int pollingEveryMili) {
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))  // Max waiting
				.pollingEvery(Duration.ofMillis(pollingEveryMili))  // polling frequency
				.ignoring(NoSuchElementException.class);  //  condition			
		// above 4 line is only for creating object
		
		WebElement ele12 = wait2.until(new Function<WebDriver, WebElement>()
				{
						public WebElement apply(WebDriver driver)
						{
							return element;	
						}
				}
				);
		return ele12;
	}
	
	
	public WebElement switchToIframe(WebDriver driver, WebElement element ) {
		// switching to iframe
		driver.switchTo().frame(element);
		return element;
	}
	
	
	public Alert alertPopup(WebDriver driver) {
//		//Alert pop up handling == hidden division, alert, child pop up
		Alert alt = driver.switchTo().alert();
		return alt;	
	}
	
	
	public WebElement jsScrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}
	
	
	public WebElement jsClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
		return element;
	}
	
	
	public void scrollByPixel(WebDriver driver, int x, int y ){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(" + x +  ", "+y+")");
	}
	
	
	public String currentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

}
