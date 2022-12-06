package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.utility.Utility;

public class HomePage {
		
	//
	@FindBy(xpath = "(//div[@class='shop-menu pull-right']/ul/li/a/i)[10]")	////div[@class='shop-menu pull-right']/ul/li/a/i[@class='fa fa-user']
	private WebElement LoggedInAs;
	
	
	private WebDriver driver;
	private Utility util;
	
	public HomePage(WebDriver driver, Utility util) {
		
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}
	

	public boolean verifyHomePage() {
		util.actionsClick(driver, LoggedInAs);
		return util.elementIsDisplayed(driver, LoggedInAs);
	}
	
	
}
