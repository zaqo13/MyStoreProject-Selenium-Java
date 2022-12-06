package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass_self;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;


public class HomePageTestClass extends BaseClass_self{
	
	private HomePage homepage;
	private LoginPage loginPage;
	private IndexPage indexPage;
	
	@Test(dataProvider = "data-providerLogIn", dataProviderClass=DataProviders.class)
	public void loggedInAsTest(String username, String pwd) {
		
		Log.startTestCase("loggedInAs");
		indexPage= new IndexPage(driver,util);
		indexPage.clickOnSignIn();
		Log.info("Clicked on Signup/Login");
		
		loginPage= new LoginPage(driver, util);
		loginPage.login(username, pwd);
		Log.info("Login Successfully");
		
		homepage =new HomePage(driver, util);
		boolean result = homepage.verifyHomePage();
		Assert.assertTrue(result);
		Log.info("'Logged In As' is found and HomePage is validated ");
		Log.endTestCase("loggedInAs");	
	}
	

}
