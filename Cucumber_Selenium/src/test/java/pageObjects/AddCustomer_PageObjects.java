package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitHelper;

public class AddCustomer_PageObjects {

	public WebDriver ldriver;
	public WaitHelper helper;

	public AddCustomer_PageObjects(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		helper = new WaitHelper(ldriver);
	}

	By linkCustomer_menu = By.xpath("//a[@href='#']//span[contains(text(),'Customers')]"); //i[@class='fa fa-user']");
	By linkCustomers_menuItem = By.xpath("//a[@href='/Admin/Customer/List']//span[contains(text(),'Customers')]");//i[@class='fa fa-user']/following::span[2]");
	By btnAddNew = By.xpath("//a[@class='btn bg-blue']");
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");

	By txtCustomerRoles = By.xpath("//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover']");

	By dltRole = By.xpath("//span[@title='delete']");
	By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");

	By drpmgrOfVendor = By.xpath("//*[@id='VendorId']");
	By rdMaleGender = By.id("Gender_Male");
	By rdFemaleGende = By.id("Gender_Female");

	By txtFirstName = By.id("FirstName");
	By txtLastName = By.id("LastName");
	By txtDOB = By.xpath("//input[@id='DateOfBirth']");

	By txtCompanyName = By.id("Company");
	By txtAdminContent = By.id("//textarea[@id='AdminComment']");

	By btnSave = By.xpath("//button[@name='save']");

	// Action Methods
	public void clickOnCustomersMenu() throws InterruptedException {
		helper.WaitForElement(ldriver.findElement(By.xpath("//a[@href='#']//span[contains(text(),'Customers')]")), 20);
		ldriver.findElement(linkCustomer_menu).click();
		Thread.sleep(2000);
	}

	
	public void clickOnCustomersMenuItem() {
		ldriver.findElement(linkCustomers_menuItem).click();
		
	}
	
	public void clickOnAddNew() {
		ldriver.findElement(btnAddNew).click();
	}
	
	public void enterEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setCustomerRoles(String role) throws InterruptedException {
		
//		if(!role.equals("Vendors"))
//		{
//			ldriver.findElement(By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']//ul[@id='SelectedCustomerRoleIds_taglist']")).click();;
//		}
		
		ldriver.findElement(txtCustomerRoles).click();
		
		WebElement listItems = null;
		Thread.sleep(3000);
		
		if(role.equals("Administrators"))
				{
			listItems=ldriver.findElement(lstitemAdministrators);
				}
		else if(role.equals("Guests"))
				{
			listItems=ldriver.findElement(lstitemGuests);
				}
		else if(role.equals("Registered"))
				{
			listItems=ldriver.findElement(lstitemRegistered);
				}
		else if(role.equals("Vendors"))
				{
			listItems=ldriver.findElement(lstitemVendors);
				}
	
	//	listItems.click();
		
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listItems);
		
		
	}
	
	public void setManagerOfVendor(String value) {
		Select sel = new Select(ldriver.findElement(drpmgrOfVendor));
		sel.selectByVisibleText(value);
		
	}
	
	public void setGender(String gender) {
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdMaleGender).click();
		}
		else if (gender.equals("Female"))
		{
			ldriver.findElement(rdFemaleGende).click();
		}
		else
		{
			ldriver.findElement(rdMaleGender).click();
		}
	}
	
	
	public void setFirstName(String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void setDOB(String dob) {
		ldriver.findElement(txtDOB).sendKeys(dob);
	}
	
	public void deleteRoles() throws InterruptedException {
		Thread.sleep(2000);
		ldriver.findElement(dltRole).click();
	}
	
	public void setCompanyName(String comname) {
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}
	public void setAdminContent(String content) {
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}
	public void clickOnSave() {
		ldriver.findElement(btnSave).click();
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
