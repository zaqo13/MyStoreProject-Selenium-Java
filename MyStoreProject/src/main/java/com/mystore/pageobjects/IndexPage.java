package com.mystore.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.utility.Utility;

public class IndexPage {
	
	
	
	@FindBy (xpath = "//a[@href='/login']")
	private WebElement login;
	
	@FindBy (xpath = "//img[@src='/static/images/home/logo.png']")  
	private WebElement myStoreLogo;
	
	@FindBy(xpath ="//div[@id='Women']")
	private WebElement Women;
	
	@FindBy(xpath = "//a[@href='/brand_products/Biba']")
	private WebElement Biba;
	
	@FindBy (xpath = "//a[@href=\"/products\"]")
	private WebElement Products;
	
	@FindBy (xpath = "//a[@href='/view_cart']")
	private WebElement Cart;
	
	@FindBy (xpath = "//a[@href='/contact_us']")
	private WebElement ContactUs;
	
	@FindBy (xpath = "//a[@href='/iframe']")
	private WebElement iFrameElement;
	
	private WebDriver driver;
	private Utility util;
	
	public IndexPage(WebDriver driver, Utility util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}
	
	 
	
	public void clickOnSignIn() {
		
		util.waitForVisibilityOf(driver, login, 10).click();
//		util.fluentWait(driver, login, 10, 500).click();

	}
	
	public boolean verifyLogo() {
		
//		return util.fluentWait(driver, login, 10, 500).isDisplayed();
		return util.elementIsDisplayed(driver, myStoreLogo);
		
	}
	
	
	public String getMyStoreTitle() {
		String myStoreTitle = driver.getTitle();
		return myStoreTitle;
	}
	
	
	
	public void clickOnBiba_Product() {
		
		util.jsScrollIntoView(driver, Biba);
		util.elementIsDisplayed(driver, Biba );
		Biba.click();
	}
	
	
	public void switchToIframeMethod( ) {
		
		util.switchToIframe(driver, iFrameElement).click();
	}
	
	public void alertPopupMethod() {
		
		util.alertPopup(driver).accept();		//		.dismiss();		.sendKeys();;		.getText();

	}
	
	public void scrollByPixelMethod() {
		
		util.scrollByPixel(driver, 0, 200);
	}
	
	

}
