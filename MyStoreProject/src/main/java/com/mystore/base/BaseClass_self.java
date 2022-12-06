package com.mystore.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import com.mystore.utility.Utility;
import com.mystore.utility.Log;



public class BaseClass_self {
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream ip;
	public static Utility util;
	
	@BeforeSuite
	public void beforeSuite() {

		
		DOMConfigurator.configure("log4j.xml");
		Log.info("This is beforeSuit Method");

		
		try {
			prop = new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Config.properties");
			prop.load(ip);						
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String browserName = prop.getProperty("browser");

		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");		//ChromeDriver 107.0.5304.62
			driver = new ChromeDriver();
			util = new Utility();

		
//		} else if(browserName.contains("Firefox")) {
//			driver = new FirefoxDriver();
//		
//		} else if(browserName.contains("IE")) {
//			driver = new InternetExplorerDriver();
		}
		
		System.out.println("driver: "+driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(
//				Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		
	}

	
}
	