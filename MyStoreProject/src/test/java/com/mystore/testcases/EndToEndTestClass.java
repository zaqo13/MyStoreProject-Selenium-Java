package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass_self;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.CheckoutPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.PaymentDonePage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.ProductDetailsPage;
import com.mystore.pageobjects.ProductsPage;
import com.mystore.pageobjects.ViewCartPage;
import com.mystore.utility.Log;

public class EndToEndTestClass extends BaseClass_self {
	
	private IndexPage indexPage;
	private LoginPage loginPage;
	private ProductsPage productPage;
	private ProductDetailsPage productDetailsPage;
	private ViewCartPage viewCartPage;
	private CheckoutPage checkoutPage;
	private PaymentPage paymentPage;
	private PaymentDonePage paymentDonePage;

	
	@Test(dataProvider = "data-providerLogIn", dataProviderClass = DataProviders.class)
	public void endToendTest(String userName, String password) {
		
		Log.startTestCase("endToEnd");
		indexPage = new IndexPage(driver, util);
		indexPage.clickOnSignIn();
		
		loginPage = new LoginPage(driver,util);
		Log.info("Entering login details");
		loginPage.login(userName, password);
		Log.info("Login Successfully");
				
		productPage = new ProductsPage(driver,util);
		Log.info("Selecting the product ");
		productPage.clickOnViewProduct();
		
		productDetailsPage = new ProductDetailsPage(driver,util);
		int productPrice = productDetailsPage.getProductPrice();
		Log.info("Price of product on 'Add to cart' / 'ProductDetails' page = "+productPrice);
		productDetailsPage.clickOnAddToCart();
		Log.info("clicked on Add to cart ");
		productDetailsPage.clickOnContinueShopping();
		Log.info("Clicked on Continue Shopping option");
		productDetailsPage.clickOnCart();
		Log.info("Cliking the Shopping cart option from menu");
		
		viewCartPage = new ViewCartPage(driver,util);
		int productTotal = viewCartPage.getTotalPrice();
		Log.info("Price of product on 'Shopping cart' / 'ViewCart' page "+productTotal);
		viewCartPage.clickOnProceedToCheckout();
		Log.info("Procceding for ckeckout the product");
		
		checkoutPage = new CheckoutPage(driver,util);
		checkoutPage.clickOnPlaceOrder();
		Log.info("Clicking on Place the order");
		
		paymentPage = new PaymentPage(driver,util);
		Log.info("Entering the Bank card details");
		paymentPage.enterNameOnCard(prop.getProperty("nameOnCard"));
		paymentPage.enterNumberOnCard(prop.getProperty("numberOnCard"));
		paymentPage.enterCvcOnCard(prop.getProperty("cvcOnCard"));
		paymentPage.enterExpirationMonth(prop.getProperty("expirationMonth"));
		paymentPage.enterExpirationYear(prop.getProperty("expirationYear"));
		Log.info("Clicking on Pay and confirm the order");
		paymentPage.clickOnPayAndConfirm();
		
		paymentDonePage = new PaymentDonePage(driver,util);
		String actual = paymentDonePage.getConfirmationText();
		String expected =prop.getProperty("orderConfirmationExpected");
		Assert.assertEquals(actual,expected);
		Log.info("Order Confirmation text matched = "+actual);
		paymentDonePage.clickOnContinue();
		Log.info("Logging out!");
		
		loginPage.clickLogout();
		
		Log.endTestCase("endToEnd");
		
	}

}
