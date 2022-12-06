package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.utility.Utility;

public class LoginPage {
	
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement UserName;
	
	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement Password;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement Submit;
	
	@FindBy(xpath = "//div[@class='shop-menu pull-right']/ul/li/a[@href='/logout']")		//
	private WebElement Logout;
	
	
	private WebDriver driver;
	private Utility util;
	
	
	public LoginPage(WebDriver driver, Utility util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}
	
	
	public void typeUserName(String userName) {

		util.waitForVisibilityOf(driver, UserName, 5).sendKeys(userName);
	}
	
	
	public void typePassword(String password) {
		
		util.waitForVisibilityOf(driver, Password, 5).sendKeys(password);
	}
	
	
	public void clickLSubmit() {
		
		util.waitForVisibilityOf(driver, Submit, 5).click();
	}
	
	
	public void clickLogout() {
		util.waitForVisibilityOf(driver, Logout, 10).click();
	}
	
	
	public void login(String userName, String password) {
		util.waitForVisibilityOf(driver, UserName, 5).sendKeys(userName);
		util.waitForVisibilityOf(driver, Password, 5).sendKeys(password);
		util.waitForClickable(driver, Submit, 5).click();
	}
		
		
		
		
	

}
