package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomer_PageObjects;
import pageObjects.LoginPage_PageObjects;
import pageObjects.SearchCustomerPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage_PageObjects login;
	public AddCustomer_PageObjects addCust;
	public SearchCustomerPage searchCustPage;
	public static Logger logger;
	public Properties configProp;
	
	

	// Generate random unique string
	public static String randomString() {
		String generatedRandomString = RandomStringUtils.randomAlphabetic(5);
		return generatedRandomString;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

}
