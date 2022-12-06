package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.utility.Utility;

public class ProductsPage {
	
	@FindBy(xpath = "//a[@href='/product_details/2']")
	private WebElement Product2;
	
	
	
	private WebDriver driver;
	private Utility util;
	
	public ProductsPage(WebDriver driver, Utility util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnViewProduct() {
		util.jsScrollIntoView(driver, Product2).click();
	}

}
