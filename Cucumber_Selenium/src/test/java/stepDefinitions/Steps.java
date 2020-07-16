package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AddCustomer_PageObjects;
import pageObjects.LoginPage_PageObjects;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {

	public static String Aplbrowser;

	@Before
	public void setu() throws IOException {

		logger = Logger.getLogger("Cucumber_Selenium");
		PropertyConfigurator.configure("log4j.properties");

		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("C:\\config.properties");
		configProp.load(configPropFile);

		Aplbrowser = configProp.getProperty("browser");
		

		if (Aplbrowser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();

		} else if (Aplbrowser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new ChromeDriver();
		} else if (Aplbrowser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.geckodriver.driver", configProp.getProperty("firefoxpath"));
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}

	@Given("^User Launch Chrome browser$")
	public void user_Launch_Chrome_browser() {

		logger.info(" *** Launching Browser *** ");
		login = new LoginPage_PageObjects(driver);

	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url) {
		logger.info(" *** Launching URL *** ");
		driver.get(url);

	}

	@When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String ename, String pword) {
		logger.info(" *** Providing login detailsr *** ");

		login.enterUserName(ename);
		login.enterPassword(pword);
	}

	@When("^Click in Login$")
	public void click_in_Login() {
		logger.info(" *** logging into  noCommerce *** ");

		login.clickLoginBtn();

	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_Title_should_be(String title) {

		if (driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}

	}

	@When("^User click on Log out link$")
	public void user_click_on_Log_out_link() throws Throwable {
		login.clickLogoutBtn();
		Thread.sleep(3000);
	}

	@Then("^close browser$")
	public void close_browser() {
		logger.info(" *** Closing Browser *** ");

		driver.close();
		driver.quit();
	}

	// New Customer step definitions:

	@Then("^User can view Dashboard$")
	public void user_can_view_Dashboard() throws Throwable {

		addCust = new AddCustomer_PageObjects(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", getPageTitle());
	}

	@When("^User click on Customers Menu$")
	public void user_click_on_Customers_Menu() throws Throwable {
		addCust.clickOnCustomersMenu();
		Thread.sleep(3000);
	}

	@When("^Click on customers Menu Item$")
	public void click_on_customers_Menu_Item() throws Throwable {
		addCust.clickOnCustomersMenuItem();
		Thread.sleep(3000);
	}

	@When("^Click on Add new Button$")
	public void click_on_Add_new_Button() throws Throwable {
		addCust.clickOnAddNew();
		Thread.sleep(2000);
	}

	@Then("^User can view Add new customer Page$")
	public void user_can_view_Add_new_customer_Page() throws Throwable {
		Assert.assertEquals("Add a new customer / nopCommerce administration", getPageTitle());
		System.out.println("page tittle: ->" + getPageTitle());
	}

	@When("^User enter Customer info$")
	public void user_enter_Customer_info() throws Throwable {

		logger.info(" *** Entering Customer Info *** ");

		String email = randomString() + "@jala.com";

		addCust.enterEmail(email);
		addCust.enterPassword("test123");
		addCust.setFirstName("Jala");
		addCust.setLastName("pathi");
		addCust.setGender("Male");
		addCust.setDOB("08/08/2019");
		addCust.setCompanyName("RIDHA");
		addCust.deleteRoles();
		addCust.setCustomerRoles("Guests");

	}

	@When("^Click on Save button$")
	public void click_on_Save_button() throws Throwable {
		logger.info(" *** Saving customer info *** ");

		addCust.clickOnSave();
		Thread.sleep(2000);
	}

	@Then("^User can view confirmaton message \"([^\"]*)\"$")
	public void user_can_view_confirmaton_message(String title) throws Throwable {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));

	}

	// Search email id:
	@Given("^Enter Customer Email$")
	public void enter_Customer_Email() throws Throwable {
		logger.info(" *** Entering customer Email to search *** ");

		searchCustPage = new SearchCustomerPage(driver);

		searchCustPage.txtEnterEmail("victoria_victoria@nopCommerce.com");
	}

	@When("^Click on search button$")
	public void click_on_search_button() throws Throwable {
		searchCustPage.btnClickOnSearch();
		Thread.sleep(3000);
	}

	@Then("^User should found Email in the Search table$")
	public void user_should_found_Email_in_the_Search_table() throws Throwable {
		String emailId = driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[1]")).getText();
		System.out.println("emailId:-> " + emailId);
		Assert.assertTrue(emailId.contains("victoria_victoria@nopCommerce.com"));

		String name = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[1]/td[3]")).getText();
		System.out.println(name);
		String names[] = name.split(" ");
		System.out.println(names);

		if (names[0].equals("Victoria") && names[1].equals("Terces")) {
			System.out.println("true that Names contains Victoria and Terces");
		} else {
			System.out.println("No names does't contains those names");
		}
	}

}
