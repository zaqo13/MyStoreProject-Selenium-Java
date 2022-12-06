package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.utility.Utility;

public class ProductDetailsPage {
	
	@FindBy(xpath = "//div[@class='product-information']//span//span")
	private WebElement Price;
	
	@FindBy(xpath = "//button[@class='btn btn-default cart']")
	private WebElement AddToCart;
	
	@FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
	private WebElement ContinueShopping;
	
	@FindBy(xpath = "//li//a[@href='/view_cart']")
	private WebElement Cart;
	
	
	private WebDriver driver;
	private Utility util;

	public ProductDetailsPage(WebDriver driver, Utility util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}
	
	
	public int getProductPrice() {
		
		String price = util.waitForVisibilityOf(driver, Price, 5).getText();	//Rs. 400
		String onlyNumbers= price.replaceAll("[^0-9]", "");		//400
		int number=0;
		try{
			number = Integer.parseInt(onlyNumbers);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
		return number ;			
	}
	
	
	public void clickOnAddToCart() {
		util.actionsClick(driver, AddToCart);
	}
	
	
	public void clickOnContinueShopping() {
		util.elementIsDisplayed(driver, ContinueShopping);
		util.waitForClickable(driver, ContinueShopping,5).click();
	}
	
	
	public void clickOnCart() {
		util.waitForVisibilityOf(driver, Cart, 5).click();
	}
	
	
	

}
