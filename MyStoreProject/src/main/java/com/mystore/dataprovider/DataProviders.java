package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider (name = "data-providerLogIn")
	public Object[][] dpLoginPassword()
	{
		
		return new Object[][] {{"email01@gmail.com", "password01"}};
//							   {"email02@gmail.com", "password02"},
//							   {"email03@gmail.com", "password03"}};		
	}
	
	

}
