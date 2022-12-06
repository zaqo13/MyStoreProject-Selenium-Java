package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.utility.Utility;

public class PaymentPage {
	@FindBy(xpath = "//input[@name='name_on_card']")
	private WebElement NameOnCard;
	
	@FindBy(xpath = "//input[@name='card_number']")
	private WebElement NumberOnCard;
	
	@FindBy(xpath = "//input[@name='cvc']")
	private WebElement CvcOnCard;
	
	@FindBy(xpath = "//input[@name='expiry_month']")
	private WebElement ExpirationMonth;
	
	@FindBy(xpath = "//input[@name='expiry_year']")
	private WebElement ExpirationYear;
	
	@FindBy(xpath = "//button[@class='form-control btn btn-primary submit-button']")
	private WebElement PayAndConfirm;
	
	
	
	
	private WebDriver driver;
	private Utility util;
	
	public PaymentPage(WebDriver driver, Utility util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);	
	}
	
	
	public void enterNameOnCard(String name) {
		util.waitForVisibilityOf(driver, NameOnCard, 5).sendKeys(name);	
	}
	
	
	public void enterNumberOnCard(String number) {
		util.waitForVisibilityOf(driver, NumberOnCard, 5).sendKeys(number);
	}
	
	
	public void enterCvcOnCard(String cvc) {
		util.waitForVisibilityOf(driver, CvcOnCard, 5).sendKeys(cvc);	
	}
	
	
	public void enterExpirationMonth(String month) {
		util.waitForVisibilityOf(driver, ExpirationMonth, 5).sendKeys(month);	
	}

	
	public void enterExpirationYear(String year) {
		util.waitForVisibilityOf(driver, ExpirationYear, 5).sendKeys(year);	
	}

	
	public void clickOnPayAndConfirm() {
		util.elementIsDisplayed(driver, PayAndConfirm);
		util.jsClick(driver, PayAndConfirm);
	}
	
}
