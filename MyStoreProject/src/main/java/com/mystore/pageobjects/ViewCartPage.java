package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.utility.Utility;

public class ViewCartPage {
	
	@FindBy(xpath = "//div/table/tbody/tr/td/p[@class='cart_total_price']")
	private WebElement TotalPrice;
	
	@FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
	private WebElement ProceedToCheckout;
	
	
	private WebDriver driver;
	private Utility util;
	
	public ViewCartPage(WebDriver driver, Utility util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);	
	}
	
	
	public int getTotalPrice() {
		String totalPrice = util.waitForVisibilityOf(driver, TotalPrice,5).getText();
		String onlyNumbers= totalPrice.replaceAll("[^0-9]", "");		//400
		int number=0;
		try{
			number = Integer.parseInt(onlyNumbers);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
		return number;
	}
	
	
	public void clickOnProceedToCheckout() {
		util.waitForVisibilityOf(driver, ProceedToCheckout, 5).click();	
	}

}
