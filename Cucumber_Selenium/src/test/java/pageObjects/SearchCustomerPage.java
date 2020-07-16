package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	public WebDriver driver;
	public WaitHelper helper;
	
	public SearchCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		helper = new WaitHelper(driver);
	}

	@FindBy(how = How.ID, using="SearchEmail")
	private WebElement txtEmail;
	
	@FindBy(how = How.XPATH, using="//button[@id='search-customers']")
	private WebElement btnSearch;
	
	@FindBy(how = How.XPATH, using="//table[@id='customers-grid']")
	private WebElement table;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
	private WebElement tableRows;
	
	@FindBy(how = How.XPATH, using="//table[@id='customers-grid']//tbody/tr/td")
	private WebElement tableColumns;
	
	public void txtEnterEmail(String email) {
		helper.WaitForElement(txtEmail, 10);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void btnClickOnSearch() {
		btnSearch.click();
	}
	
	public Dimension getNoOfRows() {
		return (tableRows.getSize());
	}
	
	public Dimension getNoOfColumns() {
		return (tableColumns.getSize());
	}
	
//	public boolean searchCustomerByEmail(String email) {
//		boolean flag=false;
//		
//		for(int i=1; i<=getNoOfRows(); i++)
//		{
//		    String emailId = driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[1]")).getText();
//		    System.out.println(emailId);
//		    if(emailId.equals(emailId))
//		    {
//		    	flag=true;
//		    }
//		}
//			return flag;
//			
//			
//	}
//	
//	
//	
//	public boolean searchCustomerByName(String email) {
//		boolean flag=false;
//		
//		for(int i=1; i<=getNoOfRows(); i++)
//		{
//		    String name = driver.findElement(By.xpath("////table[@id='customers-grid']//tbody/tr[1]/td[3]")).getText();
//		    System.out.println(name);
//		    String names[]=name.split(" ");
//		    System.out.println(names);
//
//		    if(names[0].equals("Victoria") && names[1].equals("Terces"))
//		    {
//		    	flag=true;
//		    }
//		}
//			return flag;
//			
//			
//	}

}
