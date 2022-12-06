package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.utility.Utility;

public class PaymentDonePage {
	
	@FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/p")
	private WebElement Confirmed;
	
	@FindBy(xpath = "//div[@class='pull-right']")
	private WebElement Continue;
	
	private WebDriver driver;
	private Utility util;
	
	public PaymentDonePage(WebDriver driver, Utility util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);	
	}
	
	
	public String getConfirmationText() {
		return util.waitForVisibilityOf(driver, Confirmed, 5).getText();
	}
	
	
	public void clickOnContinue() {
		util.waitForClickable(driver, Continue, 10).click();
	}

}
