package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass_self;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTestClass extends BaseClass_self{
	
	
	private IndexPage indexPage;
	private LoginPage loginPage;

	

	
	@Test(dataProvider = "data-providerLogIn", dataProviderClass = DataProviders.class)
	public void loginTest(String userName, String password) {
		
		Log.startTestCase("login");
		indexPage = new IndexPage(driver, util);
		indexPage.clickOnSignIn();
		Log.info("clicked on Signup/Login");
		
		loginPage = new LoginPage(driver,util);
		loginPage.typeUserName(userName);
		Log.info("User Name entred");
		loginPage.typePassword(password);
		Log.info("Password entred successfully and Clicking Submit button for Login");
		loginPage.clickLSubmit();
		Log.info("Login Successfully ");
		loginPage.clickLogout();
		Log.info("Clicked Logout");
		String actual = util.currentUrl(driver);
		String expected = prop.getProperty("loginUrlExpected");
		Assert.assertEquals(actual, expected);
		Log.info("Login page URL validated// landing page after logout");
		Log.info("Logout Successfully ");

		Log.endTestCase("login");
		
	}
	
	
	
	
	
	

}
