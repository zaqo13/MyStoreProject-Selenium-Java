package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass_self;
import com.mystore.pageobjects.IndexPage;

import com.mystore.utility.Log;



public class IndexPageTestClass extends BaseClass_self{
	
	private IndexPage indexPage;
	
	
	@Test			
	public void validateLogoTest( ) {
		
		Log.startTestCase("validateLogo");
		indexPage = new IndexPage(driver, util);
		boolean result = indexPage.verifyLogo();
		Assert.assertTrue(result);
		Log.info("Logo is validate");
		Log.endTestCase("validateLogo");
	}
		
	
	@Test				
	public void validateTitleTest() {
		
		Log.startTestCase("validateTitle");
		String actual = indexPage.getMyStoreTitle();
		String expected = prop.getProperty("titleIndex") ;
		Assert.assertEquals(actual, expected, "Title dosenot matched");
		Log.info("Title is matched ");
		Log.endTestCase("validateTitle");	
	}

}
