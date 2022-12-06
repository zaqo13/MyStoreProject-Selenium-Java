package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.utility.Utility;

public class CheckoutPage {
	
	@FindBy(xpath = "//a[@href='/payment']")
	private WebElement PlaceOrder;
	
	private WebDriver driver;
	private Utility util;
	
	public CheckoutPage(WebDriver driver, Utility util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);	
	}
	
	
	public void clickOnPlaceOrder() {
		
		util.jsScrollIntoView(driver, PlaceOrder);
		util.actionsClick(driver, PlaceOrder);
	}
	
}
